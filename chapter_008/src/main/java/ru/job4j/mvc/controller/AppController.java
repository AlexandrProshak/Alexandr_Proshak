package ru.job4j.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The AppController class.
 */
public class AppController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(AppController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //In this section can insert any welcome page instead.
            resp.sendRedirect(String.format("%s/allUsersList", req.getContextPath()));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
