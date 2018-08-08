package ru.job4j.task1.controller;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The LoginControllerTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class LoginControllerTest {

    /**
     * The test method doGet().
     * @throws IOException exception.
     * @throws ServletException exception.
     */
    @Test
    public void whenLoginIsNotPresentInCookiesThenLoginJsp() throws IOException, ServletException {
        //init
        LoginController servlet = new LoginController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getCookies()).thenReturn(null);
        when(request.getRequestDispatcher("/WEB-INF/view/login.jsp")).thenReturn(dispatcher);

        //use
        servlet.doGet(request, response);

        //check
        verify(request).getCookies();
        verify(request).getRequestDispatcher("/WEB-INF/view/login.jsp");
        verify(dispatcher).forward(request, response);
        verifyNoMoreInteractions(request, response, dispatcher);
    }
}