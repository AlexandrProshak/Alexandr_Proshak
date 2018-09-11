package ru.job4j.task5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.User;
import ru.job4j.task5.model.logic.impl.ValidateServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER_LOGIN;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER_PASSWORD;
import static ru.job4j.task5.controller.Constants.JSP_DIR;
import static ru.job4j.task5.controller.Constants.JSP_LOGIN;


/**
 * The LoginController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
                    if (cookie.getName().equals(ATTR_SYSTEM_USER_LOGIN.v())) {
                        login = cookie.getValue();
                        continue;
                    } else if (cookie.getName().equals(ATTR_SYSTEM_USER_PASSWORD.v())) {
                        password = cookie.getValue();
                        continue;
                    }
                }
                User user = ValidateServiceImpl.getInstance().isCredential(login, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    synchronized (session) {
                        session.setAttribute(ATTR_SYSTEM_USER.v(), user);
                    }
                    resp.sendRedirect(String.format("%s/", req.getContextPath()));
                } else {
                    req.getRequestDispatcher(JSP_DIR.v() + JSP_LOGIN.v()).forward(req, resp);
                }
            } else {
                req.getRequestDispatcher(JSP_DIR.v() + JSP_LOGIN.v()).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String login = req.getParameter(ATTR_SYSTEM_USER_LOGIN.v());
            String password = req.getParameter(ATTR_SYSTEM_USER_PASSWORD.v());
            User user = ValidateServiceImpl.getInstance().isCredential(login, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute(ATTR_SYSTEM_USER.v(), user);
                resp.addCookie(new Cookie(ATTR_SYSTEM_USER_LOGIN.v(), login));
                resp.addCookie(new Cookie(ATTR_SYSTEM_USER_PASSWORD.v(), password));
                resp.sendRedirect(String.format("%s/", req.getContextPath()));
            } else {
                doGet(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            doGet(req, resp);
        }
    }
}
