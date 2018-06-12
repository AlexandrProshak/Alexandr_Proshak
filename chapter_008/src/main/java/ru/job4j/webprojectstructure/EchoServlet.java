package ru.job4j.webprojectstructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The EchoServlet class.
 */
public class EchoServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       resp.setContentType("text/html");
//        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        PrintWriter writer = resp.getWriter();
        writer.write("Hello world!");
        writer.flush();
    }
}
