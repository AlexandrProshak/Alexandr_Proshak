package ru.job4j.task5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;

import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER_LOGIN;
import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER_PASSWORD;


/**
 * The LogoutController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class LogoutController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(LogoutController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(ATTR_SYSTEM_USER.v()) != null) {
                session.invalidate();
                resp.addCookie(new Cookie(ATTR_SYSTEM_USER_LOGIN.v(), "invalid"));
                resp.addCookie(new Cookie(ATTR_SYSTEM_USER_PASSWORD.v(), "invalid"));
                resp.sendRedirect(String.format("%s/login", req.getContextPath()));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(String.format("%s/login", req.getContextPath()));
            } catch (IOException e1) {
                LOG.error(e.getMessage(), e1);
            }
        }
    }
}
