package ru.job4j.task2.view;

import ru.job4j.task2.model.SqlVacancyParser;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The class App start parsing site.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class App {

    /**
     * The lunch period.
     */
    public static final int PERIOD = 24;

    /**
     * The method main.
     * @param args string args.
     */
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(App.work(), 0, PERIOD, TimeUnit.HOURS);
    }

    /**
     * The following method creates work for ScheduledExecutorService.
     * @return work.
     */
    private static Runnable work() {
    return  () -> {
            SqlVacancyParser parser = new SqlVacancyParser();
            System.out.println("    Start parsing the site ...");
            parser.start();
        };
    }
}
