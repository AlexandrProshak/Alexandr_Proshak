package ru.job4j.task1.controller;

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
    public static final String ATTRIBUTE_USER = "user";

    /**
     * The info.
     */
    public static final String ATTRIBUTE_INFO = "userInfo";

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
    public static final String PARAMETER_USER_LOGIN = "login";

    /**
     * The request parameter user's email.
     */
    public static final String PARAMETER_USER_EMAIL = "email";

    /**
     * Pages.
     **************************************************************
     * The path to the folder with all views.
     */
    public static final String PREFIX_PAGE = "/WEB-INF/view/";

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
     * The home page.
     */
    public static final String HOME_PAGE = "/WEB-INF/view/homePage.jsp";

    /**
     * The private constructor to avoid instantiation of the class.
     */
    private ControllerConstants() {
    }
}
