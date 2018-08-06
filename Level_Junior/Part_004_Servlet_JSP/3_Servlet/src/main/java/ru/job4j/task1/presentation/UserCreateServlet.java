package ru.job4j.task1.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.logic.ValidateService;
import ru.job4j.task1.logic.entity.User;
import ru.job4j.task1.logic.impl.ValidateServiceMemoryImpl;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_LOGIN;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_EMAIL;

/**
 * The UserCreateServlet class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserCreateServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(""
                + "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<p>Write user's info into the form below</p>"
                + "<form action='" + req.getContextPath() + "/create' method='post'>"
                + "  <fieldset>"
                + "    <legend>Personal user's information:</legend>"
                + "    id:<br><input type='text' name='id'><br>"
                + "    name: <br><input type='text' name='name'><br>"
                + "    login:<br><input type='text' name='login'><br>"
                + "    email:<br><input type='email' name='email'><br>"
                + "          <br><input type='submit' value='create'><br><br>"
                + " </form>"
                + " <form action='" + req.getContextPath() + "/list'>"
                + "     <button type='submit'>show all users</button>"
                + " </form>"
                + " </fieldset>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
        if (storage == null) {
            storage = ValidateServiceMemoryImpl.getInstance();
        }
        try {
            String userId = req.getParameter(PARAMETER_USER_ID);
            User user = new User();
            user.setId(Integer.valueOf(userId));
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            if (storage.add(user)) {
                req.getSession().setAttribute(ATTRIBUTE_STORAGE, storage);
                writer.append("New user was successfully created");
                writer.flush();
                doGet(req, resp);
            } else {
                writer.append("User with id: " + userId + " is already used. "
                        + "New user was not created. To create new user please select id which is not used in the db.");
                writer.flush();
                doGet(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            writer.append("Something incorrect, please check the data");
            writer.flush();
            doGet(req, resp);
        }
    }
}
