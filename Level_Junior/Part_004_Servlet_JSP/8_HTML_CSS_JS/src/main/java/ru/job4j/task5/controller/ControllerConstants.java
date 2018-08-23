package ru.job4j.task5.controller;

/**
 * The class ControllerConstants include the parameters and attributes constants.
 * It is constants' storage.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ControllerConstants {

    /**
     * Attributes.
     **************************************************************
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
     * The countries.
     */
    public static final String ATTRIBUTE_COUNTRIES = "countries";

    /**
     * Parameters.
     **************************************************************
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
     * The request parameter user's country.
     */
    public static final String PARAMETER_USER_COUNTRY = "country";

    /**
     * The request parameter user's city.
     */
    public static final String PARAMETER_USER_CITY = "city";

    /**
     * Pages.
     **************************************************************
     * The path to the folder with all views.
     */
    public static final String PREFIX_PAGE = "/WEB-INF/views/";

    /**
     * The page for showing all users.
     */
    public static final String ALL_USERS_PAGE = "users.jsp";

    /**
     * The page for updating user.
     */
    public static final String UPDATE_USER_PAGE = "update.jsp";

    /**
     * The page for an empty storage.
     */
    public static final String EMPTY_PAGE = "emptyPage.jsp";

    /**
     * The page for creating new user.
     */
    public static final String CREATE_USER_PAGE = "create.jsp";

    /**
     * The page for login a user.
     */
    public static final String LOGIN_PAGE = "login.jsp";

    /**
     * The private constructor to avoid instantiation of the class.
     */
    private ControllerConstants() {
    }
}
