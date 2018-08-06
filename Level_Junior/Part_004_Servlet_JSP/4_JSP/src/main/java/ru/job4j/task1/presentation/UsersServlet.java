package ru.job4j.task1.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task1.logic.ValidateService;
import ru.job4j.task1.logic.entity.User;
import ru.job4j.task1.logic.impl.ValidateServiceMemoryImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

import static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_ID;

/**
 * The UsersServlet class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UsersServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            ValidateService storage = ValidateServiceMemoryImpl.getInstance();
            session.setAttribute(ATTRIBUTE_STORAGE, storage);
            if (storage == null) {
                RequestDispatcher page = req.getRequestDispatcher("empty.jsp");
                page.forward(req, resp);
            } else {
                Collection<User> all = storage.findAll();
                if (!all.isEmpty()) {
                    resp.sendRedirect("users.jsp");
                } else {
                    resp.sendRedirect("empty.jsp");
                }
            }
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect("ajax.jsp");
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter(PARAMETER_USER_ID);
            if (id != null) {
                Integer integerId = Integer.valueOf(id);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                storage.delete(integerId);
                doGet(req, resp);
            } else {
                LOG.error("Null users to delete.");
                doGet(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            doGet(req, resp);
        }
    }
}
