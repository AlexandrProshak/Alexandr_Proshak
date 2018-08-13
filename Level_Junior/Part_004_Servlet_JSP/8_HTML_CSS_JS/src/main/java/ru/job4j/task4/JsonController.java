package ru.job4j.task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Person class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class JsonController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(JsonController.class);

    /**
     * The key in the storage.
     */
    private final AtomicInteger index = new AtomicInteger(1);

    /**
     * The storage.
     */
    private final Map<Integer, Person> storage = new ConcurrentHashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            StringBuilder result = new StringBuilder();
            BufferedReader reader = req.getReader();
            if (reader != null) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(result.toString(), Person.class);
            this.storage.put(index.getAndIncrement(), person);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
