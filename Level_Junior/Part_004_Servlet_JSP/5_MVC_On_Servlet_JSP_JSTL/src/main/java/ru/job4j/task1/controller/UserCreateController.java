package ru.job4j.task1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.model.entity.User;
import ru.job4j.task1.model.logic.ValidateService;
import ru.job4j.task1.model.logic.impl.ValidateServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.job4j.task1.controller.ControllerConstants.HOME_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.CREATE_USER_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_INFO;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_LOGIN;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_EMAIL;


/**
 * The UserCreateController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserCreateController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher page = req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE));
            if (page != null) {
                req.setAttribute(ATTRIBUTE_INFO, "Creating new user ...");
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, HOME_PAGE)).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, HOME_PAGE)).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e.getMessage(), e1);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
            if (storage == null) {
                storage = ValidateServiceImpl.getInstance();
            }
            User user = new User();
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            if (storage.add(user)) {
                req.getSession().setAttribute(ATTRIBUTE_STORAGE, storage);
                req.setAttribute(ATTRIBUTE_INFO, "New user was successfully created");
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE)).forward(req, resp);
            } else {
                req.setAttribute(ATTRIBUTE_INFO, "User with this id - is already used, please type another id.");
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE)).forward(req, resp);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute(ATTRIBUTE_INFO, "Something was incorrect, please check the date!");
            try {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE)).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
