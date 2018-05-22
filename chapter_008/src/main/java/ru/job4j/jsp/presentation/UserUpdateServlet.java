package ru.job4j.jsp.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The UserUpdateServlet class.
 */
public class UserUpdateServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserUpdateServlet.class);

    /**
     * The request attribute storage.
     */
    public static final String ATTRIBUTE_STORAGE = "storage";

    /**
     * The request attribute updated user.
     */
    public static final String ATTRIBUTE_USER = "user";

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
            String userId = req.getParameter(PARAMETER_USER_ID);
            if (userId != null) {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
                User userById = storage.findById(id);
                if (userById == null) {
                    resp.sendRedirect("index.jsp");
                } else {
                    req.setAttribute(ATTRIBUTE_USER, userById);
                    req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("users.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException  e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect("index.jsp");
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ValidateService storage = (ValidateService) req.getSession().getAttribute(ATTRIBUTE_STORAGE);
            User user = new User();
            user.setId(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)));
            user.setName(req.getParameter(PARAMETER_USER_NAME));
            user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
            user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(PARAMETER_USER_ID))).getCrateDate());
            storage.update(user);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect("index.jsp");
            } catch (IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
