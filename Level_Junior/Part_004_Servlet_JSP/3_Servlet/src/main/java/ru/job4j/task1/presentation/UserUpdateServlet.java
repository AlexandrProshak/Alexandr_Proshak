package ru.job4j.task1.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.logic.ValidateService;
import ru.job4j.task1.logic.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_LOGIN;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_EMAIL;
import static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_STORAGE;

/**
 * The UserUpdateServlet class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserUpdateServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserUpdateServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String userId = req.getParameter(PARAMETER_USER_ID);
        if (userId != null) {
            try {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                User userById = storage.findById(id);
                if (userById == null) {
                    writer.append(""
                            + "<!DOCTYPE html>"
                            + "<html>"
                            + "<body>"
                            + "<p>There is not any user with current id " + userId + "</p>"
                            + " <form action='" + req.getContextPath() + "/list'>"
                            + "     <button type='submit'>show all users</button>"
                            + " </form>"
                            + " </fieldset>"
                            + "</body>"
                            + "</html>");
                } else {
                    writer.append(""
                            + "<!DOCTYPE html>"
                            + "<html>"
                            + "<body>"
                            + "<p>Edit user's info into the form below</p>"
                            + "<form action='" + req.getContextPath() + "/edit' method='post'>"
                            + "  <fieldset>"
                            + "    <legend>Personal user's information:</legend>"
                            + "    id:   <br><input type='text' name='id' value='" + userById.getId() + "' readonly><br>"
                            + "    name: <br><input type='text' name='name' value='" + userById.getName() + "'><br>"
                            + "    login:<br><input type='text' name='login' value='" + userById.getLogin() + "'><br>"
                            + "    email:<br><input type='email' name='email' value='" + userById.getEmail() + "'><br>"
                            + "          <br><input type='submit' value='update'><br><br>"
                            + " </form>"
                            + " <form action='" + req.getContextPath() + "/list'>"
                            + "     <button type='submit'>show all users</button>"
                            + " </form>"
                            + " </fieldset>"
                            + "</body>"
                            + "</html>");
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + " <form action='" + req.getContextPath() + "/create'>"
                        + "     <button type='submit'>create new</button>"
                        + " </form>"
                        + "</body>"
                        + "</html>");
                writer.flush();
            }
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
        try {
            User user = new User();
            user.setId(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)));
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(PARAMETER_USER_ID))).getCrateDate());
            if (storage.update(user)) {
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + " <form action='" + req.getContextPath() + "/list'>"
                        + "     <button type='submit'>show all users</button>"
                        + " </form>"
                        + "</body>"
                        + "</html>");
                writer.flush();
            } else {
                writer.append("Something incorrect, please check the data");
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + " <form action='" + req.getContextPath() + "/create'>"
                        + "     <button type='submit'>create new</button>"
                        + " </form>"
                        + "</body>"
                        + "</html>");
                writer.flush();
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            writer.append("Something incorrect, please check the data");
            writer.append(""
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<body>"
                    + " <form action='" + req.getContextPath() + "/create'>"
                    + "     <button type='submit'>create new</button>"
                    + " </form>"
                    + "</body>"
                    + "</html>");
            writer.flush();
            doGet(req, resp);
        }
    }
}
