package ru.job4j.task1.controller;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


/**
 * The AppControllerTest class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class AppControllerTest {

    /**
     * The test method doGet().
     * @throws IOException exception.
     */
    @Test
    public void whenSendRegThanReturnHelloWorld() throws IOException {
        //init
        AppController servlet = new AppController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getContextPath()).thenReturn("http://localhost:8080/item/");

        //use
        servlet.doGet(request, response);

        //check
        verify(request).getContextPath();
        verify(response).sendRedirect("http://localhost:8080/item//allUsersList");
        verifyNoMoreInteractions(request, response);
    }
}
