package ru.job4j.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.logic.impl.ValidateServiceMemoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The UserCreateController class.
 */
public class UserCreateController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateController.class);

    /**
     * The request attribute storage.
     */
    public static final String ATTRIBUTE_STORAGE = "storage";

    /**
     * The info.
     */
    public static final String ATTRIBUTE_INFO = "userInfo";

    /**
     * The path to the folder with all views.
     */
    public static final String PREFIX_PAGE = "/WEB-INF/view/";

    /**
     * The page for creating new user.
     */
    public static final String CREATE_USER_PAGE = "createUserPage.jsp";

    /**
     * The home page.
     */
    public static final String HOME_PAGE = "homePage.jsp";

    /**
     * The request parameter user's id.
     */
    public static final String PARAMETER_USER_ID = "id";

    /**
     * The request parameter user's name.
     */
    public static final String PARAMETER_USER_NAME = "name";

    /**
     * The request parameter user's login.
     */
    public static final String PARAMETER_USER_LOGIN = "login";

    /**
     * The request parameter user's email.
     */
    public static final String PARAMETER_USER_EMAIL = "email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher page = req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE));
            if (page != null) {
                req.setAttribute(ATTRIBUTE_INFO, "Creating new user ...");
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, HOME_PAGE)).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, HOME_PAGE)).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e.getMessage(), e1);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
            if (storage == null) {
                storage = ValidateServiceMemoryImpl.getInstance();
            }
            String userId = req.getParameter(PARAMETER_USER_ID);
            User user = new User();
            user.setId(Integer.valueOf(userId));
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            if (storage.add(user)) {
                req.getSession().setAttribute(ATTRIBUTE_STORAGE, storage);
                req.setAttribute(ATTRIBUTE_INFO, "New user was successfully created");
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE)).forward(req, resp);
            } else {
                req.setAttribute(ATTRIBUTE_INFO, "User with id=" + userId + " - is already used, please type another id.");
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE)).forward(req, resp);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute(ATTRIBUTE_INFO, "Something was incorrect, please check the date!");
            try {
                req.getRequestDispatcher(String.format("%s%s", PREFIX_PAGE, CREATE_USER_PAGE)).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
