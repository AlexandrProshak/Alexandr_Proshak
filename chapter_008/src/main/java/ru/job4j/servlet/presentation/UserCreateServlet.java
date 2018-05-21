package ru.job4j.servlet.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.logic.impl.ValidateServiceMemoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The UserCreateServlet class.
 */
public class UserCreateServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);

    /**
     * The request attribute storage.
     */
    public static final String ATTRIBUTE_STORAGE = "storage";

    /**
     * The request parameter user's id.
     */
    public static final String PARAMETER_USER_ID = "id";

    /**
     * The request parameter user's name.
     */
    public static final String PARAMETER_USER_NAME = "name";

    /**
     * The request parameter user's login.
     */
    public static final String PARAMETER_USER_LOGIN = "login";

    /**
     * The request parameter user's email.
     */
    public static final String PARAMETER_USER_EMAIL = "email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(""
                + "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<p>Write user's info into the form below</p>"
                + "<form action=" + req.getContextPath() + "/create method='post'>"
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
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
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
