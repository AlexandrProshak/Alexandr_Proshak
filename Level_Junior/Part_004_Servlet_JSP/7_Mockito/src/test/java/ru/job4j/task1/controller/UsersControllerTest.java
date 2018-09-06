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
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_STORAGE;
import static ru.job4j.task1.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ALL_USERS_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.EMPTY_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_ID;

/**
 * The UsersControllerTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateServiceImpl.class)
public class UsersControllerTest {


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
     * UserCreateController servlet.
     */
    private UsersController servlet;

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
        this.servlet = new UsersController();
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
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenNoUserInDbThenGoEmptyJsp() throws IOException, ServletException {
        //init
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(PREFIX_PAGE + EMPTY_PAGE)).thenReturn(dispatcher);

        //use
        servlet.doGet(request, response);

        //check
        verify(session).setAttribute(ATTRIBUTE_STORAGE, storage);
        verify(dispatcher).forward(request, response);
    }

    /**
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenUserInDbThenGoUsersJsp() throws IOException, ServletException {
        //init
        when(request.getSession()).thenReturn(session);
        storage.add(new User());
        storage.add(new User());
        when(request.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE)).thenReturn(dispatcher);

        //use
        servlet.doGet(request, response);

        //check
        verify(session).setAttribute(ATTRIBUTE_STORAGE, storage);
        verify(dispatcher).forward(request, response);
    }


    /**
     * The test method doPost().
     */
    @Test
    public void whenRemoveNullUserThenDoGet() {
        //init
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn(null);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE)).thenReturn(dispatcher);
        when(request.getRequestDispatcher(PREFIX_PAGE + EMPTY_PAGE)).thenReturn(dispatcher);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(storage);
        assertThat(storage.findAll().size(), is(0));

        //use
        servlet.doPost(request, response);

        //check
        assertThat(storage.findAll().size(), is(0));

    }

    /**
     * The test method doPost().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenRemoveUserThenDeleteItFromDb() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("0");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE)).thenReturn(dispatcher);
        when(request.getRequestDispatcher(PREFIX_PAGE + EMPTY_PAGE)).thenReturn(dispatcher);
        User user = new User();
        user.setName("name");
        user.setLogin("login");
        user.setPassword("password");
        user.setEmail("email");
        user.setRole(Role.user);
        storage.add(user);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(storage);
        assertThat(storage.findAll().size(), is(1));

        //use
        servlet.doPost(request, response);

        //check
        assertThat(storage.findAll().size(), is(0));
    }
}