package ru.job4j.task5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.City;
import ru.job4j.task5.model.entity.Country;
import ru.job4j.task5.model.entity.Role;
import ru.job4j.task5.model.logic.ValidateService;
import ru.job4j.task5.model.entity.User;
import ru.job4j.task5.model.logic.impl.ValidateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static ru.job4j.task5.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task5.controller.ControllerConstants.ALL_USERS_PAGE;
import static ru.job4j.task5.controller.ControllerConstants.CREATE_USER_PAGE;
import static ru.job4j.task5.controller.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task5.controller.ControllerConstants.ATTRIBUTE_INFO;
import static ru.job4j.task5.controller.ControllerConstants.ATTRIBUTE_COUNTRIES;
import static ru.job4j.task5.controller.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task5.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.task5.controller.ControllerConstants.USER_PASSWORD;
import static ru.job4j.task5.controller.ControllerConstants.PARAMETER_USER_ROLE;
import static ru.job4j.task5.controller.ControllerConstants.PARAMETER_USER_EMAIL;
import static ru.job4j.task5.controller.ControllerConstants.PARAMETER_USER_COUNTRY;
import static ru.job4j.task5.controller.ControllerConstants.PARAMETER_USER_CITY;

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
            Collection<Country> countries = ValidateServiceImpl.getInstance().findAllCountries();
            RequestDispatcher page = req.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE);
            if (page != null && !countries.isEmpty()) {
                req.setAttribute(ATTRIBUTE_COUNTRIES, countries);
                req.setAttribute(ATTRIBUTE_INFO, "Creating new user ...");
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
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
            Role role = Role.valueOf(req.getParameter(PARAMETER_USER_ROLE));
            if (Role.admin.equals(role)) {
                user.setRole(Role.admin);
            } else {
                user.setRole(Role.user);
            }
            user.setCountry(req.getParameter(PARAMETER_USER_COUNTRY));
            user.setCity(req.getParameter(PARAMETER_USER_CITY));
            if (storage.add(user)) {
                req.getSession().setAttribute(ATTRIBUTE_STORAGE, storage);
                req.setAttribute(ATTRIBUTE_INFO, "New user was successfully created");
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
            } else {
                req.setAttribute(ATTRIBUTE_INFO, "New user was not created, please check the data.");
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
            }

        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute(ATTRIBUTE_INFO, "Something was incorrect, please check the date!");
            try {
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
