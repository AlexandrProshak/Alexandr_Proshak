package ru.job4j.task1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.model.entity.Role;
import ru.job4j.task1.model.entity.User;
import ru.job4j.task1.model.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.job4j.task1.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.UPDATE_USER_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ALL_USERS_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_USER;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_SYSTEM_USER;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.task1.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.task1.controller.ControllerConstants.USER_PASSWORD;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_ROLE;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_EMAIL;

/**
 * The UserUpdateController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserUpdateController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserUpdateController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String userId = req.getParameter(PARAMETER_USER_ID);
            if (userId != null) {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                User userById = storage.findById(id);
                if (userById == null) {
                    resp.sendRedirect(String.format("%s/", req.getContextPath()));
                } else {
                    req.setAttribute(ATTRIBUTE_USER, userById);
                    req.getRequestDispatcher(PREFIX_PAGE + UPDATE_USER_PAGE).forward(req, resp);
                }
            } else {
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
            }
        } catch (ServletException | IOException  e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(String.format("%s/", req.getContextPath()));
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
            user.setLogin(req.getParameter(USER_LOGIN));
            user.setPassword(req.getParameter(USER_PASSWORD));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            user.setRole(Role.valueOf(req.getParameter(PARAMETER_USER_ROLE)));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(PARAMETER_USER_ID))).getCrateDate());
            storage.update(user);
            if (((User) req.getSession().getAttribute(ATTRIBUTE_SYSTEM_USER)).getId()
                    == Integer.valueOf(req.getParameter(PARAMETER_USER_ID))) {
                req.getSession().setAttribute(ATTRIBUTE_SYSTEM_USER, user);
                resp.addCookie(new Cookie(USER_LOGIN, user.getLogin()));
                resp.addCookie(new Cookie(USER_PASSWORD, user.getPassword()));
            }
            req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(String.format("%s/", ALL_USERS_PAGE));
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
