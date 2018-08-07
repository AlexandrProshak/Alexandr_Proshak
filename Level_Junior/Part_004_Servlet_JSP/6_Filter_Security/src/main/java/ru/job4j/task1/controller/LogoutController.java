package ru.job4j.task1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;

import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_SYSTEM_USER;
import static ru.job4j.task1.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.task1.controller.ControllerConstants.USER_PASSWORD;

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
            if (session.getAttribute(ATTRIBUTE_SYSTEM_USER) != null) {
                session.invalidate();
                resp.addCookie(new Cookie(USER_LOGIN, "invalid"));
                resp.addCookie(new Cookie(USER_PASSWORD, "invalid"));
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
