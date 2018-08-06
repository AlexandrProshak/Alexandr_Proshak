package ru.job4j.task1;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * The EchoServletTest class.
 */
public class EchoServletTest {

    /**
     * The test method doGet().
     * @throws IOException exception.
     */
    @Test
    public void whenSendRegThanReturnHelloWorld() throws IOException {
        //init
        EchoServlet servlet = new EchoServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);

        when(response.getWriter()).thenReturn(writer);

        //use
        servlet.doGet(request, response);

        //check
        verify(response).setContentType("text/html");
        verify(response).getWriter();
        verify(writer).write("Hello world!");
        verify(writer).flush();
        verifyNoMoreInteractions(request, response, writer);
    }
}