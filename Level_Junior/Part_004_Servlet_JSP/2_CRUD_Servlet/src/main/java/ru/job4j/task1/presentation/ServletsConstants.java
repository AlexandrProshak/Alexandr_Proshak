package ru.job4j.task1.presentation;

/**
 * The ServletsConstants class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ServletsConstants {

    /**
     *  ------- PARAMETERS -------
     *
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
     * ------- ATTRIBUTES -------
     *
     * The request attribute for the collection with all users.
     */
    public static final String ATTRIBUTE_ALL_USERS = "all";

    /**
     * The request attribute for the user found by id.
     */
    public static final String ATTRIBUTE_USER_BY_ID = "userById";

    /**
     * The private constructor to avoid instantiation.
     */
    private ServletsConstants() {
    }
}
