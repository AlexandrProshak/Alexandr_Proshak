package ru.job4j.mvc.controller;

/**
 * The class ControllerConstants include the parameters and attributes constants.
 * It is constants' storage.
 */
public class ControllerConstants {

    /**
     * Attributes.
     */
    /**
     * The request attribute storage.
     */
    public static final String ATTRIBUTE_STORAGE = "storage";

    /**
     * The request attribute updated user.
     */
    public static final String ATTRIBUTE_SYSTEM_USER = "systemUser";

    /**
     * The request attribute updated user.
     */
    public static final String ATTRIBUTE_USER = "user";

    /**
     * The session's attribute error.
     */
    public static final String ATTRIBUTE_ERROR = "error";

    /**
     * The info.
     */
    public static final String ATTRIBUTE_INFO = "userInfo";

    /**
     * Parameters.
     */
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
    public static final String USER_LOGIN = "login";

    /**
     * The request parameter user's password.
     */
    public static final String USER_PASSWORD = "password";

    /**
     * The request parameter user's email.
     */
    public static final String PARAMETER_USER_EMAIL = "email";

    /**
     * The request parameter user's role.
     */
    public static final String PARAMETER_USER_ROLE = "role";

    /**
     * Pages.
     */
    /**
     * The path to the folder with all views.
     */
    public static final String PREFIX_PAGE = "/WEB-INF/view/";

    /**
     * The home page.
     */
    public static final String HOME_PAGE = "homePage_OLD.jsp";

    /**
     * The page for showing all users.
     */
    public static final String ALL_USERS_PAGE = "usersPage.jsp";

    /**
     * The page for updating user.
     */
    public static final String UPDATE_USER_PAGE = "updateUserPage.jsp";

    /**
     * The page for an empty storage.
     */
    public static final String EMPTY_PAGE = "emptyPage.jsp";

    /**
     * The page for creating new user.
     */
    public static final String CREATE_USER_PAGE = "createUserPage.jsp";

    /**
     * The page for login a user.
     */
    public static final String LOGIN_PAGE = "loginPage.jsp";


}
