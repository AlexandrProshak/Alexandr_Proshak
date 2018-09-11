package ru.job4j.task5.controller;

/**
 * The Constants enum.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public enum  Constants {
    /**
     *  Parameters are related to user.
     *  *******************************
     */
    /** The parameter user id. **/
    PARAM_USER_ID("id"),
    /** The parameter user name. **/
    PARAM_USER_NAME("name"),
    /** The parameter user login. **/
    PARAM_USER_LOGIN("login"),
    /** The parameter user password. **/
    PARAM_USER_PASSWORD("password"),
    /** The parameter user email. **/
    PARAM_USER_EMAIL("email"),
    /** The parameter user role. **/
    PARAM_USER_ROLE("role"),
    /** The parameter user country. **/
    PARAM_USER_COUNTRY("country"),
    /** The parameter user city. **/
    PARAM_USER_CITY("city"),

    /**
     * Attributes.
     * ***********
     */
    /** The attribute info. **/
    ATTR_INFO("userInfo"),
    /** The attribute countries. **/
    ATTR_COUNTRIES("countries"),
    /** The attribute storage. **/
    ATTR_STORAGE("storage"),
    /** The attribute system user. **/
    ATTR_SYSTEM_USER("systemUser"),
    /** The attribute system user login. **/
    ATTR_SYSTEM_USER_LOGIN("systemUserLogin"),
    /** The attribute system user password. **/
    ATTR_SYSTEM_USER_PASSWORD("systemUserPassword"),
    /** The attribute system user. **/
    ATTR_USER("user"),

    /**
     * JSP pages.
     * **********
     */
    /** The folder contains all jsp pages. **/
    JSP_DIR("/WEB-INF/views/"),
    /** The users page. **/
    JSP_USERS("users.jsp"),
    /** The login page. **/
    JSP_LOGIN("login.jsp"),
    /** The create user page. **/
    JSP_CREATE_USER("create.jsp"),
    /** The update user page. **/
    JSP_UPDATE_USER("update.jsp");

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
