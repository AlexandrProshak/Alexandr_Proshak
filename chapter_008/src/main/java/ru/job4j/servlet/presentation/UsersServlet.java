package ru.job4j.servlet.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.logic.impl.ValidateServiceMemoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * The UsersServlet class.
 */
public class UsersServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);

    /**
     * The request parameter user's id.
     */
    public static final String PARAMETER_USER_ID = "id";

    /**
     * The request attribute storage.
     */
    public static final String ATTRIBUTE_STORAGE = "storage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        //PrintWriter writer = new PrintWriter(resp.getOutputStream());
        PrintWriter writer = resp.getWriter();
        ValidateService storage = (ValidateService) session.getAttribute(ATTRIBUTE_STORAGE);
        String noUsers = "<!DOCTYPE html>"
                + "<html lang=en>"
                + "<head>"
                + "    <meta charset=UTF-8>"
                + "    <title>From UsersServlet</title>"
                + "</head>"
                + "<body>"
                + "<fieldset>"
                + "<legend>There are no any users yet</legend>"
                + "<form action='" + req.getContextPath() + "/create'>"
                + "             <button type='submit'>create new</button>"
                + " </form>"
                + "</fieldset>"
                + "</body>"
                + "</html>";
        if (storage == null) {
            session.setAttribute(ATTRIBUTE_STORAGE, ValidateServiceMemoryImpl.getInstance());
            writer.append(noUsers);
        } else {
            Collection<User> all = storage.findAll();
            if (!all.isEmpty()) {
                StringBuilder builder = new StringBuilder();
                builder.append("<table>"
                        + "<tr>"
                        + "     <th>id</th>"
                        + "     <th>name</th>"
                        + "     <th>login</th>"
                        + "     <th>email</th>"
                        + "     <th>date</th>"
                        + "     <th>action</th>"
                        + "</tr>");
                for (User user : all) {
                    builder.append(""
                            + "<tr>"
                            + "    <td>" + user.getId() + "</td>"
                            + "    <td>" + user.getName() + "</td>"
                            + "    <td>" + user.getLogin() + "</td>"
                            + "    <td>" + user.getEmail() + "</td>"
                            + "    <td>" + user.getCrateDate() + "</td>"
                            + "    <td><form action='" + req.getContextPath() + "/edit' method='get'>"
                            + "             <button value='" + user.getId() + "' name='id' type='submit'>edit</button>"
                            + "        </form>"
                            + "        <form action='" + req.getContextPath() + "/list' method='post'>"
                            + "             <button value='" + user.getId() + "' name='id' type='submit'>remove</button>"
                            + "        </form>"
                            + "    </td>"
                            + "</tr>");
                }
                builder.append("</table>");
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html lang='en'>"
                        + "<head>"
                        + "    <meta charset='UTF-8'>"
                        + "    <title>From UsersServlet</title>"
                        + "         <style>"
                        + "             table { width:100%; }"
                        + "             table, th, td { border: 2px solid black; border-collapse: collapse; }"
                        + "                    th, td { padding: 5px; text-align: center; }"
                        + "         </style>"
                        + "</head>"
                        + "<body>"
                        + "<fieldset>"
                        + "<legend>Current users</legend>"
                        + builder.toString()
                        + "</fieldset>"
                        + "</body>"
                        + "</html>");
            } else {
                writer.append(noUsers);
            }
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter(PARAMETER_USER_ID);
        if (id != null) {
            try {
                Integer integerId = Integer.valueOf(id);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                storage.delete(integerId);
                doGet(req, resp);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                doGet(req, resp);
            }
        } else {
            LOG.error("Null users to delete.");
            doGet(req, resp);
        }
    }
}
