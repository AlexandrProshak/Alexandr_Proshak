package ru.job4j.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.logic.impl.ValidateServiceMemoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * The UsersController class.
 */
public class UsersController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsersController.class);

    /**
     * The home page.
     */
    public static final String HOME_PAGE = "homePage.jsp";

    /**
     * The path to the folder with all views.
     */
    public static final String PREFIX_PAGE = "/WEB-INF/view/";

    /**
     * The page for an empty storage.
     */
    public static final String EMPTY_PAGE = "emptyPage.jsp";

    /**
     * The page for showing all users.
     */
    public static final String ALL_USERS_PAGE = "usersPage.jsp";

    /**
     * The request parameter user's id.
     */
    public static final String PARAMETER_USER_ID = "id";

    /**
     * The request attribute storage.
     */
    public static final String ATTRIBUTE_STORAGE = "storage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            ValidateService storage = ValidateServiceMemoryImpl.getInstance();
            session.setAttribute(ATTRIBUTE_STORAGE, storage);
            if (storage == null) {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, EMPTY_PAGE)).forward(req, resp);
            } else {
                Collection<User> all = storage.findAll();
                if (all.isEmpty()) {
                    req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, EMPTY_PAGE)).forward(req, resp);
                } else {
                    req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, ALL_USERS_PAGE)).forward(req, resp);
                }
            }
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(String.format("%s%s", PREFIX_PAGE, HOME_PAGE));
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
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                Integer integerId = Integer.valueOf(id);
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
