package ru.job4j.task5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.Country;
import ru.job4j.task5.model.logic.ValidateService;
import ru.job4j.task5.model.logic.impl.ValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

import static ru.job4j.task5.controller.Constants.ATTR_COUNTRIES;
import static ru.job4j.task5.controller.Constants.ATTR_STORAGE;
import static ru.job4j.task5.controller.Constants.PARAM_USER_ID;
import static ru.job4j.task5.controller.Constants.JSP_DIR;
import static ru.job4j.task5.controller.Constants.JSP_USERS;

/**
 * The UsersController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UsersController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            ValidateService storage = ValidateServiceImpl.getInstance();
            Collection<Country> countries = storage.findAllCountries();
            session.setAttribute(ATTR_STORAGE.v(), storage);
            session.setAttribute(ATTR_COUNTRIES.v(), countries);
            req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(JSP_DIR.v() + JSP_USERS.v());
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }

    /**
     * The doPost method is used for removing user from db.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter(PARAM_USER_ID.v());
            if (id != null) {
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTR_STORAGE.v());
                Integer integerId = Integer.valueOf(id);
                storage.delete(integerId);
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
            } else {
                LOG.error("Null users to delete.");
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            doGet(req, resp);
        }
    }

}
