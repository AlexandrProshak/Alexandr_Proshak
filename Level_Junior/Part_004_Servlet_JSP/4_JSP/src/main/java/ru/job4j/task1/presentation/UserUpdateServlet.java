package ru.job4j.task1.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.logic.ValidateService;
import ru.job4j.task1.logic.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_USER;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_LOGIN;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_EMAIL;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String userId = req.getParameter(PARAMETER_USER_ID);
            if (userId != null) {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                User userById = storage.findById(id);
                if (userById == null) {
                    resp.sendRedirect("ajax.jsp");
                } else {
                    req.setAttribute(ATTRIBUTE_USER, userById);
                    req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("users.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException  e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect("ajax.jsp");
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
            User user = new User();
            user.setId(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)));
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(PARAMETER_USER_ID))).getCrateDate());
            storage.update(user);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect("ajax.jsp");
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
