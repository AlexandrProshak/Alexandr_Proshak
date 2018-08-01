package ru.job4j.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.mvc.model.entity.User;
import ru.job4j.mvc.model.logic.impl.ValidateServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import static ru.job4j.mvc.controller.ControllerConstants.ATTRIBUTE_SYSTEM_USER;
import static ru.job4j.mvc.controller.ControllerConstants.ATTRIBUTE_ERROR;
import static ru.job4j.mvc.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.mvc.controller.ControllerConstants.LOGIN_PAGE;
import static ru.job4j.mvc.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.mvc.controller.ControllerConstants.USER_PASSWORD;

/**
 * The LoginController class.
 */
public class LoginController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                String login = null;
                String password = null;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(USER_LOGIN)) {
                        login = cookie.getValue();
                        continue;
                    } else if (cookie.getName().equals(USER_PASSWORD)) {
                        password = cookie.getValue();
                        continue;
                    }
                }
                User user = ValidateServiceImpl.getInstance().isCredential(login, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    synchronized (session) {
                        session.setAttribute(ATTRIBUTE_SYSTEM_USER, user);
                    }
                    resp.sendRedirect(String.format("%s/", req.getContextPath()));
                } else {
                    req.getRequestDispatcher(PREFIX_PAGE + LOGIN_PAGE).forward(req, resp);
                }
            } else {
                req.getRequestDispatcher(PREFIX_PAGE + LOGIN_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String login = req.getParameter(USER_LOGIN);
            String password = req.getParameter(USER_PASSWORD);
            User user = ValidateServiceImpl.getInstance().isCredential(login, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute(ATTRIBUTE_SYSTEM_USER, user);
                resp.addCookie(new Cookie(USER_LOGIN, login));
                resp.addCookie(new Cookie(USER_PASSWORD, password));
                resp.sendRedirect(String.format("%s/", req.getContextPath()));
            } else {
                req.setAttribute(ATTRIBUTE_ERROR, "Current login or password is not present in the system. "
                        + "Please check data or make registration.");
                doGet(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            doGet(req, resp);
        }
    }
}
