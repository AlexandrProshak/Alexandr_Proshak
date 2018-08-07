package ru.job4j.task1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.model.entity.User;
import ru.job4j.task1.model.logic.impl.ValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import static ru.job4j.task1.controller.ControllerConstants.ALL_USERS_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.PREFIX_PAGE;

/**
 * The CheckLoginController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CheckLoginController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CheckLoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        try {
        String login = req.getParameter("loginParam");
        Collection<User> users = ValidateServiceImpl.getInstance().findAll();
        boolean free = true;
        for (User user: users) {
            if (user.getLogin().equals(login)) {
                free = false;
                break;
            }
        }
        PrintWriter writer = resp.getWriter();
        resp.setContentType("txt/html");
        resp.setCharacterEncoding("UTF-8");
        if (free) {
            writer.print("free");
            writer.flush();
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

}
