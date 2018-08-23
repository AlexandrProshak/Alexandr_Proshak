package ru.job4j.task5.controller;

/**
 * The Constants enum.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public enum  Constants {
    /**
     *  Parameters are related to user.
     */
    PARAM_USER("user"),
    PARAM_USER_ID("id"),
    PARAM_USER_NAME("name"),
    PARAM_USER_LOGIN("login"),
    PARAM_USER_PASSWORD("password"),
    PARAM_USER_EMAIL("email"),
    PARAM_USER_ROLE("role"),
    PARAM_USER_COUNTRY("country"),
    PARAM_USER_CITY("city"),
    /**
     * Parameter logged user.
     */
    PARAM_LOGGED_USER("loggedUser"),
    /**
     * Parameter all users.
     */
    PARAM_ALLUSERS("users"),
    /**
     * Logged system user parameters.
     */
    USER_LOGIN("login"),
    USER_PASSWORD("password"),
    /**
     * Attributes.
     */
    ATTR_ERROR("error"),
    ATTR_INFO("userInfo"),
    ATTR_COUNTRIES("countries"),
    ATTR_STORAGE("storage"),
    ATTR_SYSTEM_USER("systemUser"),


    /**
     * JSP pages.
     */
    JSP_DIR("/WEB-INF/views"),
    JSP_CREATE_USER("/user_create_validation.jsp"),
    JSP_UPDATE_USER("/update.jsp"),
    JSP_DELETE_USER("/delete.jsp"),
    JSP_LIST_USER("/list.jsp"),
    JSP_LOGIN("/page-parts/user-login-modal-dialog.jsp"),
    /**
     * URI path.
     */
    URI_CREATE_USER("/create"),
    URI_UPDATE_USER("/update"),
    URI_DELETE_USER("/delete"),
    URI_LIST_USER("/list");

    /**
     * Value of a parameter.
     */
    private final String value;

    /**
     * Constructor.
     * @param value inner essence of a parameter.
     */
    Constants(String value) {
        this.value = value;
    }

    /**
     * Getter.
     * @return value.
     */
    public String v() {
        return this.value;
    }
}
