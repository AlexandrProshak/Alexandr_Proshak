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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.times;
import static ru.job4j.task1.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.CREATE_USER_PAGE;
import static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_INFO;
import static ru.job4j.task1.controller.ControllerConstants.USER_LOGIN;
import static ru.job4j.task1.controller.ControllerConstants.USER_PASSWORD;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_NAME;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_ROLE;
import static ru.job4j.task1.controller.ControllerConstants.PARAMETER_USER_EMAIL;

/**
 * The UserCreateControllerTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateServiceImpl.class)
public class UserCreateControllerTest {

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
    private UserCreateController servlet;

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
        this.servlet = new UserCreateController();
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
    public void whenCreateUserPageExistingThenGoCreateJsp() throws IOException, ServletException {
        //init
        when(request.getRequestDispatcher("/WEB-INF/view/create.jsp")).thenReturn(dispatcher);

        //use
        servlet.doGet(request, response);

        //check
        verify(request).getRequestDispatcher("/WEB-INF/view/create.jsp");
        verify(dispatcher).forward(request, response);
        verify(request).setAttribute(ATTRIBUTE_INFO, "Creating new user ...");
        verifyNoMoreInteractions(request, dispatcher);
    }

    /**
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenCreateUserPageNotExistingThenGoUsersJsp() throws IOException, ServletException {
        //init
        when(request.getRequestDispatcher("/WEB-INF/view/create.jsp")).thenReturn(null);
        when(request.getRequestDispatcher("/WEB-INF/view/users.jsp")).thenReturn(dispatcher);

        //use
        servlet.doGet(request, response);

        //check
        verify(request).getRequestDispatcher("/WEB-INF/view/create.jsp");
        verify(request).getRequestDispatcher("/WEB-INF/view/users.jsp");
        verify(dispatcher).forward(request, response);
        verifyNoMoreInteractions(request, dispatcher);
    }

    /**
     * The test method doPost().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenCreateNewUserUserThenAddItToDb() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_NAME)).thenReturn("name");
        when(request.getParameter(USER_LOGIN)).thenReturn("login");
        when(request.getParameter(USER_PASSWORD)).thenReturn("password");
        when(request.getParameter(PARAMETER_USER_EMAIL)).thenReturn("email");
        when(request.getParameter(PARAMETER_USER_ROLE)).thenReturn("user");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE)).thenReturn(dispatcher);
        assertTrue(storage.findAll().isEmpty());

        //use
        servlet.doPost(request, response);

        //check
        verify(request).getParameter(PARAMETER_USER_NAME);
        verify(request).getParameter(USER_LOGIN);
        verify(request).getParameter(USER_PASSWORD);
        verify(request).getParameter(PARAMETER_USER_EMAIL);
        verify(request).getParameter(PARAMETER_USER_ROLE);
        verify(request).setAttribute(ATTRIBUTE_INFO, "New user was successfully created");
        verify(dispatcher).forward(request, response);
        assertThat(storage.findAll().iterator().next().getName(), is("name"));
    }

    /**
     * The test method doPost().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenCreateNewAdminThenAddItToDb() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_NAME)).thenReturn("name");
        when(request.getParameter(USER_LOGIN)).thenReturn("login");
        when(request.getParameter(USER_PASSWORD)).thenReturn("password");
        when(request.getParameter(PARAMETER_USER_EMAIL)).thenReturn("email");
        when(request.getParameter(PARAMETER_USER_ROLE)).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE)).thenReturn(dispatcher);

        //use
        servlet.doPost(request, response);

        //check
        verify(request).getParameter(PARAMETER_USER_NAME);
        verify(request).getParameter(USER_LOGIN);
        verify(request).getParameter(USER_PASSWORD);
        verify(request).getParameter(PARAMETER_USER_EMAIL);
        verify(request).getParameter(PARAMETER_USER_ROLE);
        verify(request).setAttribute(ATTRIBUTE_INFO, "New user was successfully created");
        verify(dispatcher).forward(request, response);

        User result = storage.findById(0);
        assertThat(result.getId(), is(0));
        assertThat(result.getName(), is("name"));
        assertThat(result.getLogin(), is("login"));
        assertThat(result.getRole(), is(Role.admin));
        assertThat(storage.findAll().iterator().next().getRole(), is(Role.admin));
    }

    /**
     * The test method doPost().
     */
    @Test
    public void whenCreateUserWhichExistedThenNotAdd() {
        //init
        when(request.getParameter(PARAMETER_USER_NAME)).thenReturn("name");
        when(request.getParameter(USER_LOGIN)).thenReturn("login");
        when(request.getParameter(USER_PASSWORD)).thenReturn("password");
        when(request.getParameter(PARAMETER_USER_EMAIL)).thenReturn("email");
        when(request.getParameter(PARAMETER_USER_ROLE)).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE)).thenReturn(dispatcher);

        //use
        servlet.doPost(request, response);
        servlet.doPost(request, response);

        //check
        verify(request, times(2)).getParameter(PARAMETER_USER_NAME);
        verify(request, times(2)).getParameter(USER_LOGIN);
        verify(request, times(2)).getParameter(USER_PASSWORD);
        verify(request, times(2)).getParameter(PARAMETER_USER_EMAIL);
        verify(request, times(2)).getParameter(PARAMETER_USER_ROLE);
        assertThat(storage.findAll().size(), is(1));
    }

    /**
     * The test method doPost().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenCreateNewButIllegalArgumentExceptionThenAddIncorrectInfo() throws IOException, ServletException {
        //init
        when(request.getParameter(PARAMETER_USER_NAME)).thenReturn(null);
        when(request.getRequestDispatcher(PREFIX_PAGE + CREATE_USER_PAGE)).thenReturn(dispatcher);

        //use
        servlet.doPost(request, response);

        //check
        verify(request).getParameter(PARAMETER_USER_NAME);
        verify(request).setAttribute(ATTRIBUTE_INFO, "Something was incorrect, please check the date!");
        verify(dispatcher).forward(request, response);
    }

}