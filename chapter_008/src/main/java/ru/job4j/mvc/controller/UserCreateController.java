package ru.job4j.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.mvc.model.entity.Role;
import ru.job4j.mvc.model.logic.ValidateService;
import ru.job4j.mvc.model.entity.User;
import ru.job4j.mvc.model.logic.impl.ValidateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.job4j.mvc.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.mvc.controller.ControllerConstants.CREATE_USER_PAGE;
import static ru.job4j.mvc.controller.ControllerConstants.HOME_PAGE;
import static ru.job4j.mvc.controller.ControllerConstants.ATTRIBUTE_INFO;
import static ru.job4j.mvc.controller.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.mvc.controller.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.mvc.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.mvc.controller.ControllerConstants.USER_PASSWORD;
import static ru.job4j.mvc.controller.ControllerConstants.PARAMETER_USER_ROLE;
import static ru.job4j.mvc.controller.ControllerConstants.PARAMETER_USER_EMAIL;

/**
 * The UserCreateController class.
 */
public class UserCreateController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher page = req.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE);
            if (page != null) {
                req.setAttribute(ATTRIBUTE_INFO, "Creating new user ...");
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher(PREFIX_PAGE + HOME_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher(PREFIX_PAGE + HOME_PAGE).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e.getMessage(), e1);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ValidateService storage = ValidateServiceImpl.getInstance();
            User user = new User();
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(USER_LOGIN));
            user.setPassword(req.getParameter(USER_PASSWORD));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            user.setRole(Role.valueOf(req.getParameter(PARAMETER_USER_ROLE)));
            if (storage.add(user)) {
                req.getSession().setAttribute(ATTRIBUTE_STORAGE, storage);
                req.setAttribute(ATTRIBUTE_INFO, "New user was successfully created");
                req.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE).forward(req, resp);
            } else {
                req.setAttribute(ATTRIBUTE_INFO, "New user was not created, please check the data.");
                req.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE).forward(req, resp);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute(ATTRIBUTE_INFO, "Something was incorrect, please check the date!");
            try {
                req.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
