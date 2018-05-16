package ru.job4j.crudservlet.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;
import ru.job4j.crudservlet.logic.impl.ValidateServiceMemoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The UserServlet class.
 */
public class UserServlet extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);

    /**
     * The request parameter the action type.
     */
    public static final String PARAMETER_ACTION = "action";

    /**
     * The request parameter add new user.
     */
    public static final String PARAMETER_ACTION_ADD = "add";

    /**
     * The request parameter update user by id.
     */
    public static final String PARAMETER_ACTION_UPDATE = "update";

    /**
     * The request parameter delete user by id.
     */
    public static final String PARAMETER_ACTION_DELETE = "delete";

    /**
     * The request parameter find user by id.
     */
    public static final String PARAMETER_ACTION_FIND_BY_ID = "find";

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

    /**
     * The request attribute for the collection with all users.
     */
    public static final String ATTRIBUTE_ALL_USERS = "all";

    /**
     * The request attribute for the user found by id.
     */
    public static final String ATTRIBUTE_USER_BY_ID = "userById";

    /**
     * The storage with validation.
     */
    private ValidateService service = ValidateServiceMemoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute(ATTRIBUTE_ALL_USERS, service.findAll());
        PrintWriter writer = new PrintWriter(resp.getWriter());
        writer.write(req.getAttribute(ATTRIBUTE_ALL_USERS).toString());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (req.getParameter(PARAMETER_ACTION)) {
            case PARAMETER_ACTION_ADD:
                User user = new User();
                user.setId(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)));
                user.setName(req.getParameter(PARAMETER_USER_NAME));
                user.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
                user.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
                user.setCrateDate(user.getCrateDate());
                if (!service.add(user)) {
                    LOG.error("User with same id is already existed");
                }
                break;
            case PARAMETER_ACTION_UPDATE:
                User updateUser = new User();
                updateUser.setId(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)));
                updateUser.setName(req.getParameter(PARAMETER_USER_NAME));
                updateUser.setLogin(req.getParameter(PARAMETER_USER_LOGIN));
                updateUser.setEmail(req.getParameter(PARAMETER_USER_EMAIL));
                if (!service.update(updateUser)) {
                    LOG.error("User with same id is not existed");
                }
                break;
            case PARAMETER_ACTION_DELETE:
                if (!service.delete(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)))) {
                    LOG.error("User with same id is not existed");
                }
                break;
            case PARAMETER_ACTION_FIND_BY_ID:
                User byId = service.findById(Integer.valueOf(req.getParameter(PARAMETER_USER_ID)));
                if (byId != null) {
                    req.setAttribute(ATTRIBUTE_USER_BY_ID, byId);
                    PrintWriter writer = new PrintWriter(resp.getWriter());
                    writer.write(req.getAttribute(ATTRIBUTE_USER_BY_ID).toString());
                    writer.flush();
                } else {
                    LOG.error("User with same id is not found");
                }
                break;
            default:
                LOG.error("Unknown action");
                break;
        }
    }
}
