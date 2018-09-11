package ru.job4j.task5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.Country;
import ru.job4j.task5.model.entity.Role;
import ru.job4j.task5.model.entity.User;
import ru.job4j.task5.model.logic.ValidateService;
import ru.job4j.task5.model.logic.impl.ValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static ru.job4j.task5.controller.Constants.ATTR_COUNTRIES;
import static ru.job4j.task5.controller.Constants.ATTR_STORAGE;
import static ru.job4j.task5.controller.Constants.ATTR_USER;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER_LOGIN;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER_PASSWORD;
import static ru.job4j.task5.controller.Constants.PARAM_USER_ID;
import static ru.job4j.task5.controller.Constants.PARAM_USER_NAME;
import static ru.job4j.task5.controller.Constants.PARAM_USER_LOGIN;
import static ru.job4j.task5.controller.Constants.PARAM_USER_PASSWORD;
import static ru.job4j.task5.controller.Constants.PARAM_USER_EMAIL;
import static ru.job4j.task5.controller.Constants.PARAM_USER_ROLE;
import static ru.job4j.task5.controller.Constants.PARAM_USER_COUNTRY;
import static ru.job4j.task5.controller.Constants.PARAM_USER_CITY;
import static ru.job4j.task5.controller.Constants.JSP_DIR;
import static ru.job4j.task5.controller.Constants.JSP_USERS;
import static ru.job4j.task5.controller.Constants.JSP_UPDATE_USER;


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
            Collection<Country> countries = ValidateServiceImpl.getInstance().findAllCountries();
            req.setAttribute(ATTR_COUNTRIES.v(), countries);
            String userId = req.getParameter(PARAM_USER_ID.v());
            if (userId != null) {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTR_STORAGE.v());
                User userById = storage.findById(id);
                if (userById == null) {
                    resp.sendRedirect(String.format("%s/", req.getContextPath()));
                } else {
                    req.setAttribute(ATTR_USER.v(), userById);
                    req.getRequestDispatcher(JSP_DIR.v() + JSP_UPDATE_USER.v()).forward(req, resp);
                }
            } else {
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
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
            ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTR_STORAGE.v());
            User user = new User();
            user.setId(Integer.valueOf(req.getParameter(PARAM_USER_ID.v())));
            user.setName(req.getParameter(PARAM_USER_NAME.v()));
            user.setLogin(req.getParameter(PARAM_USER_LOGIN.v()));
            user.setPassword(req.getParameter(PARAM_USER_PASSWORD.v()));
            user.setEmail(req.getParameter(PARAM_USER_EMAIL.v()));
            user.setRole(Role.valueOf(req.getParameter(PARAM_USER_ROLE.v())));
            user.setCountry(req.getParameter(PARAM_USER_COUNTRY.v()));
            user.setCity(req.getParameter(PARAM_USER_CITY.v()));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(PARAM_USER_ID.v()))).getCrateDate());
            storage.update(user);
            if (((User) req.getSession().getAttribute(ATTR_SYSTEM_USER.v())).getId()
                    == Integer.valueOf(req.getParameter(PARAM_USER_ID.v()))) {
                req.getSession().setAttribute(ATTR_SYSTEM_USER.v(), user);
                resp.addCookie(new Cookie(ATTR_SYSTEM_USER_LOGIN.v(), user.getLogin()));
                resp.addCookie(new Cookie(ATTR_SYSTEM_USER_PASSWORD.v(), user.getPassword()));
            }
            req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(String.format("%s/", JSP_USERS.v()));
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
