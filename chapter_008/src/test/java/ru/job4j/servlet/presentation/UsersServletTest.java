package ru.job4j.servlet.presentation;

import org.junit.Before;
import org.junit.Test;

import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.LinkedList;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.times;
import static ru.job4j.mvc.controller.ControllerConstants.ATTRIBUTE_STORAGE;

/**
 * The UsersServlet's class test.
 */
public class UsersServletTest {

    /**
     * The servlet's reference.
     */
    private UsersServlet servlet;

    /**
     * The request's reference.
     */
    private HttpServletRequest request;

    /**
     * The response's reference.
     */
    private HttpServletResponse response;

    /**
     * The session's reference.
     */
    private HttpSession session;

    /**
     * The set upping method initial data.
     */
    @Before
    public void setUp() {
        this.servlet = new UsersServlet();
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.session = mock(HttpSession.class);
    }

    /**
     * The doGet's method test in the case of no any user.
     * @throws IOException exception.
     */
    @Test
    public void whenNoUsersThanShowNoUsers() throws IOException {
        //init
        PrintWriter writer = mock(PrintWriter.class);
        ValidateService serviceMemory = mock(ValidateService.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("http://localhost:8080/item");
        when(response.getWriter()).thenReturn(writer);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(serviceMemory);
        when(serviceMemory.findAll()).thenReturn(Collections.EMPTY_LIST);
        String noUsers = "<!DOCTYPE html>"
                + "<html lang=en>"
                + "<head>"
                + "    <meta charset=UTF-8>"
                + "    <title>From UsersServlet</title>"
                + "</head>"
                + "<body>"
                + "<fieldset>"
                + "<legend>There are no any users yet</legend>"
                + "<form action='http://localhost:8080/item/create'>"
                + "             <button type='submit'>create new</button>"
                + " </form>"
                + "</fieldset>"
                + "</body>"
                + "</html>";

        //use
        servlet.doGet(request, response);

        //check
        verify(request).getSession();
        verify(response).getWriter();
        verify(request).getContextPath();
        verify(response).setContentType("text/html");
        verify(session).getAttribute(ATTRIBUTE_STORAGE);
        verify(writer).append(noUsers);
        verify(writer).flush();
        verifyNoMoreInteractions(request, response, session, writer);
    }

    /**
     * The doGet's method test in the case of find an user.
     * @throws IOException exception.
     */
    @Test
    public void whenUserPresentThanShowIt() throws IOException {
        //init
        PrintWriter writer = mock(PrintWriter.class);
        ValidateService serviceMemory = mock(ValidateService.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("http://localhost:8080/item");
        when(response.getWriter()).thenReturn(writer);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(serviceMemory);
        User user = mock(User.class);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        when(user.getId()).thenReturn(1);
        when(user.getName()).thenReturn("user");
        when(user.getLogin()).thenReturn("login");
        when(user.getEmail()).thenReturn("email");
        when(user.getCrateDate()).thenReturn(time);
        when(serviceMemory.findAll()).thenReturn(new LinkedList<>(asList(user)));

        //use
        servlet.doGet(request, response);

        //check
        verify(request).getSession();
        verify(response).getWriter();
        verify(request, times(3)).getContextPath();
        verify(response).setContentType("text/html");
        verify(session).getAttribute(ATTRIBUTE_STORAGE);
        verify(user, times(3)).getId();
        verify(user).getName();
        verify(user).getLogin();
        verify(user).getEmail();
        verify(user).getCrateDate();
        verify(writer).flush();
        verifyNoMoreInteractions(request, response, session);
    }

}