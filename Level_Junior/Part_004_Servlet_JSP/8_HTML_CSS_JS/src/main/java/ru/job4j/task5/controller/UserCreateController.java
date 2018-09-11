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

import static ru.job4j.task5.controller.Constants.ATTR_COUNTRIES;
import static ru.job4j.task5.controller.Constants.ATTR_STORAGE;
import static ru.job4j.task5.controller.Constants.ATTR_INFO;
import static ru.job4j.task5.controller.Constants.PARAM_USER_NAME;
import static ru.job4j.task5.controller.Constants.PARAM_USER_LOGIN;
import static ru.job4j.task5.controller.Constants.PARAM_USER_PASSWORD;
import static ru.job4j.task5.controller.Constants.PARAM_USER_EMAIL;
import static ru.job4j.task5.controller.Constants.PARAM_USER_ROLE;
import static ru.job4j.task5.controller.Constants.PARAM_USER_COUNTRY;
import static ru.job4j.task5.controller.Constants.PARAM_USER_CITY;
import static ru.job4j.task5.controller.Constants.JSP_CREATE_USER;
import static ru.job4j.task5.controller.Constants.JSP_DIR;
import static ru.job4j.task5.controller.Constants.JSP_USERS;


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
            RequestDispatcher page = req.getRequestDispatcher(JSP_DIR.v() + JSP_CREATE_USER.v());
            if (page != null && !countries.isEmpty()) {
                req.setAttribute(ATTR_COUNTRIES.v(), countries);
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
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
            user.setName(req.getParameter(PARAM_USER_NAME.v()));
            user.setLogin(req.getParameter(PARAM_USER_LOGIN.v()));
            user.setPassword(req.getParameter(PARAM_USER_PASSWORD.v()));
            user.setEmail(req.getParameter(PARAM_USER_EMAIL.v()));
            Role role = Role.valueOf(req.getParameter(PARAM_USER_ROLE.v()));
            if (Role.admin.equals(role)) {
                user.setRole(Role.admin);
            } else {
                user.setRole(Role.user);
            }
            user.setCountry(req.getParameter(PARAM_USER_COUNTRY.v()));
            user.setCity(req.getParameter(PARAM_USER_CITY.v()));
            if (isValid(user)) {
                if (storage.add(user)) {
                    req.getSession().setAttribute(ATTR_STORAGE.v(), storage);
                    req.setAttribute(ATTR_INFO.v(), "New user was successfully created");
                    req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
                }
            } else {
                req.setAttribute(ATTR_INFO.v(), "New user was not created, please check the data.");
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute(ATTR_INFO.v(), "Something was incorrect, please check the date!");
            try {
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }

    /**
     * The method check input user's personal data.
     * @param user to validate.
     * @return true if all data are valid.
     */
    private boolean isValid(User user) {
        boolean result = true;
        Collection<User> users = ValidateServiceImpl.getInstance().findAll();
        List<String> loginList = new LinkedList<>();
        List<String> emailList = new LinkedList<>();
        List<String> countryList = new LinkedList<>();
        List<String> cityList = new LinkedList<>();
        Collection<Country> allCountries = ValidateServiceImpl.getInstance().findAllCountries();
        for (Country each: allCountries) {
            countryList.add(each.getName());
        }
        if (!countryList.contains(user.getCountry())) {
            return false;
        }
        Collection<City> allCitiesByCountry = ValidateServiceImpl.getInstance().findAllCitiesByCountry(user.getCountry());
        for (City each: allCitiesByCountry) {
            cityList.add(each.getName());
        }
        if (!cityList.contains(user.getCity())) {
            return false;
        }
        for (User each: users) {
            loginList.add(each.getLogin());
            emailList.add(each.getEmail());
        }
        if (loginList.contains(user.getLogin())
                || user.getPassword().length() == 0
                || emailList.contains(user.getEmail())) {
            result = false;
        }
        return result;
    }
}
