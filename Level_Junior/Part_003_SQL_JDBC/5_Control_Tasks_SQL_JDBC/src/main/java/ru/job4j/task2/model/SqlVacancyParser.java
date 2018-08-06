package ru.job4j.task2.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task2.dao.DatabaseManager;
import ru.job4j.task2.dao.VacancyDaoImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class SqlVacancyParser.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class SqlVacancyParser {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SqlVacancyParser.class);

    /**
     * The predictable constant, which supposes an amount of java vacancies can be on a index.
     * Using for creating a size of a storage.
     */
    private static final int PREDICTED_JAVA_RECORDS_PER_PAGE = 10;

    /**
     * The connection url.
     */
    private static final String URL = "http://www.sql.ru/forum/job-offers/";

    /**
     * The queue for saving the java vacancies from the different threads.
     */
    private BlockingQueue<Vacancy> storage;

    /**
     * The number of threads.
     */
    public static final int THREADS = Runtime.getRuntime().availableProcessors() * 4;

    /**
     * The counter for multithreading parse.
     */
    private final LongAdder index = new LongAdder();

    /**
     * The lust time of parsing the site.
     */
    private Timestamp lastTimeUpdate;

    /**
     * The vacancy dao implement.
     */
    private VacancyDaoImpl dao;

    /**
     * The amount of pages for parsing.
     */
    private int pages;

    /**
     * The method starts process.
     */
    public void start() {
        this.init();
        this.lastTimeUpdate = dao.getLastUpdate();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        for (int i = 1; i <= pages; i++) {
            executorService.submit(this.parse(i));
        }
        while (index.intValue() < pages) {
            continue;
        }
        this.shutdown(executorService);
        this.saveToDb();
    }

    /**
     * The method initializes the initial data.
     */
    public void init() {
        this.dao = new VacancyDaoImpl(new DatabaseManager());
        this.pages = getPageAmount();
        this.storage = new ArrayBlockingQueue<>(pages * PREDICTED_JAVA_RECORDS_PER_PAGE);
    }

    /**
     * The following method shuts down an ExecutorService in two phases.
     * @param executorService to be shutdown.
     */
    private void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * The method retrieves the number of pages.
     * @return an amount of index.
     */
    private int getPageAmount() {
        int result = 0;
        try {
            Document document = Jsoup.connect(URL + 1).get();
            Elements elements = document.getElementsByClass("sort_options");
            result = Integer.parseInt(elements.select("a").last().text());
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * The following method is parsing the page on the site.
     * @param page current page.
     * @return a runnable object.
     */
    private Runnable parse(final int page) {
        return () -> {
            try {
                int currentPage = this.index.intValue();
                this.index.increment();
                LOG.info(String.format("> parsing page # %s", currentPage));
                Document document = Jsoup.connect(URL + page).get();
                Elements elements = document.select("tr:has(.postslisttopic)");
                for (Element elem : elements) {
                    Elements links = elem.select("a");
                    String text = links.text();
                    String loverText = text.toLowerCase();
                    if (loverText.contains("java") || loverText.contains("j2ee")) {
                        if (!loverText.contains("script")) {
                            Elements data = elem.select("td");
                            String rowData = data.get(5).text();
                            Timestamp time = getTime(rowData);
                            if (time.after(this.lastTimeUpdate)) {
                                String href = links.attr("href");
                                int id = parseId(href);
                                storage.put(new Vacancy(id, text, time, href));
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (InterruptedException | IOException e) {
                LOG.error(e.getMessage(), e);
            }
        };
    }

    /**
     * The auxiliary method for parsing the vacancy's id.
     * @param string contains id.
     * @return id.
     */
    private int parseId(String string) {
        String result = "";
        Pattern pattern = Pattern.compile("forum/(\\d+)");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return Integer.parseInt(result);
    }

    /**
     * The auxiliary method which makes right date.
     * @param string of date.
     * @return a good date.
     */
    private Timestamp getTime(String string) {
        Timestamp result = null;
        string = string.trim();
        try {
            Calendar calendar = Calendar.getInstance();
            if (string.contains("сегодня")) {
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(string.substring(9, 11)));
                calendar.set(Calendar.MINUTE, Integer.parseInt(string.substring(12, 14)));
                result = new Timestamp(calendar.getTimeInMillis());
            } else if (string.contains("вчера")) {
                calendar.set(Calendar.DAY_OF_MONTH, -1);
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(string.substring(7, 9)));
                calendar.set(Calendar.MINUTE, Integer.parseInt(string.substring(10, 12)));
                result = new Timestamp(calendar.getTimeInMillis());
            } else {
                SimpleDateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));
                calendar.setTime(format.parse(string));
                result = new Timestamp(calendar.getTimeInMillis());
            }
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * The method saves data to th db.
     */
    private void saveToDb() {
        LOG.info("Start saving data ... ~>");
        dao.saveVacancies(storage);
        dao.updateLustTimeUpdate(new Timestamp(System.currentTimeMillis()));
        LOG.info("      ... ~> Finish saving data.");
    }

}
