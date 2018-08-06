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
import java.io.IOException;

import static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_LOGIN;
import static ru.job4j.task1.presentation.ControllerConstants.PARAMETER_USER_EMAIL;

/**
 * The UserCreateServlet class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class UserCreateServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher page = req.getRequestDispatcher("createUser.jsp");
            if (page != null) {
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher("ajax.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher("ajax.jsp").forward(req, resp);
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
                req.setAttribute("userInfo", "New user was successfully created");
                req.getRequestDispatcher("createUser.jsp").forward(req, resp);
            } else {
                req.setAttribute("userInfo", "User with id=" + userId + " - is already used, please type another id.");
                req.getRequestDispatcher("createUser.jsp").forward(req, resp);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOG.error(e.getMessage(), e);
            req.setAttribute("userInfo", "Something was incorrect, please check the date!");
            try {
                req.getRequestDispatcher("createUser.jsp").forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e1.getMessage(), e1);
            }
        }
    }
}
