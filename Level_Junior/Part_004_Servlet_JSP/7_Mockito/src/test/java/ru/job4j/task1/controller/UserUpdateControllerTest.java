package ru.job4j.task1.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.task1.model.entity.Role;
import ru.job4j.task1.model.entity.User;
import ru.job4j.task1.model.logic.ValidateService;
import ru.job4j.task1.model.logic.impl.ValidateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static ru.job4j.task1.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.UPDATE_USER_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ALL_USERS_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_SYSTEM_USER;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.task1.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.task1.controller.ControllerConstants.USER_PASSWORD;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_ROLE;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_EMAIL;

/**
 * The UserUpdateControllerTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateServiceImpl.class)
public class UserUpdateControllerTest {

    /**
     * HttpServletRequest request.
     */
    private HttpServletRequest request;

    /**
     * HttpServletResponse response.
     */
    private HttpServletResponse response;

    /**
     * RequestDispatcher dispatcher.
     */
    private RequestDispatcher dispatcher;

    /**
     * ValidateService storage.
     */
    private ValidateService storage;

    /**
     * UserUpdateController servlet.
     */
    private UserUpdateController servlet;

    /**
     * HttpSession session.
     */
    private HttpSession session;

    /**
     * The setup initial data.
     */
    @Before
    public void init() {
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.dispatcher = mock(RequestDispatcher.class);
        this.storage = new ValidateServiceStub();
        this.servlet = new UserUpdateController();
        this.session = mock(HttpSession.class);
        PowerMockito.mockStatic(ValidateServiceImpl.class);
        PowerMockito.when(ValidateServiceImpl.getInstance()).thenReturn(this.storage);
    }

    /**
     * The clear test data.
     */
    @After
    public void clear() {
        this.storage.clear();
    }

    /**
     * The test method doPost().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenUpdateUserThenItUpdated() throws IOException, ServletException {
        //init
        User user = new User();
        user.setName("name");
        user.setLogin("login");
        user.setPassword("password");
        user.setEmail("email");
        user.setRole(Role.user);
        storage.add(user);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(storage);
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("0");
        when(request.getParameter(PARAMETER_USER_NAME)).thenReturn("newName");
        when(request.getParameter(USER_LOGIN)).thenReturn("login");
        when(request.getParameter(USER_PASSWORD)).thenReturn("password");
        when(request.getParameter(PARAMETER_USER_EMAIL)).thenReturn("email");
        when(request.getParameter(PARAMETER_USER_ROLE)).thenReturn("user");
        when(request.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE)).thenReturn(dispatcher);
        when(session.getAttribute(ATTRIBUTE_SYSTEM_USER)).thenReturn(new User());
        assertThat(storage.findAll().size(), is(1));

        //use
        servlet.doPost(request, response);

        //check
        verify(request, times(3)).getParameter(PARAMETER_USER_ID);
        verify(request).getParameter(PARAMETER_USER_NAME);
        verify(request).getParameter(USER_LOGIN);
        verify(request).getParameter(USER_PASSWORD);
        verify(request).getParameter(PARAMETER_USER_EMAIL);
        verify(request).getParameter(PARAMETER_USER_ROLE);
        verify(dispatcher).forward(request, response);
        assertThat(storage.findById(0).getName(), is("newName"));
    }

    /**
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenNullUserToUpdateThenShowAllUsersPage() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn(null);
        when(request.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE)).thenReturn(dispatcher);

        //use
        servlet.doGet(request, response);

        //check
        verify(request, times(1)).getParameter(PARAMETER_USER_ID);
        verify(dispatcher).forward(request, response);
    }

    /**
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenUserToUpdateIsNotInDbThenShowAllUsersPage() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("1");
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("localhost:8080/item");
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(storage);

        //use
        servlet.doGet(request, response);

        //check
        verify(request, times(1)).getParameter(PARAMETER_USER_ID);
        verify(response).sendRedirect("localhost:8080/item/");
    }

    /**
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenUserToUpdateIsInDbThenShowUpdateUsersPage() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("0");
        when(request.getSession()).thenReturn(session);
        User user = new User();
        user.setName("name");
        user.setLogin("login");
        user.setPassword("password");
        user.setEmail("email");
        user.setRole(Role.user);
        storage.add(user);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(storage);
        when(request.getRequestDispatcher(PREFIX_PAGE + UPDATE_USER_PAGE)).thenReturn(dispatcher);
        //use
        servlet.doGet(request, response);

        //check
        verify(request, times(1)).getParameter(PARAMETER_USER_ID);
        verify(dispatcher).forward(request, response);
    }
}