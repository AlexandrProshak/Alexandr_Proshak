package ru.job4j.servlet.presentation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.logic.entity.User;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static ru.job4j.servlet.presentation.UserUpdateServlet.ATTRIBUTE_STORAGE;
import static ru.job4j.servlet.presentation.UserUpdateServlet.PARAMETER_USER_ID;
import static uk.org.lidalia.slf4jtest.LoggingEvent.error;

/**
 * The UserUpdateServlet class.
 */
public class UserUpdateServletTest {

    /**
     * The servlet's reference.
     */
    private UserUpdateServlet servlet;

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
     * The special test logger.
     */
    private TestLogger logger;

    /**
     * The set upping method initial data.
     */
    @Before
    public void setUp() {
        this.servlet = new UserUpdateServlet();
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.session = mock(HttpSession.class);
        this.logger = TestLoggerFactory.getTestLogger(UserUpdateServlet.class);
    }

    /**
     * The cleaning data.
     */
    @After
    public void clearLoggers() {
        TestLoggerFactory.clear();
    }

    /**
     * The doGet's method test in the case of didn't find an user in the db by id.
     * @throws IOException exception.
     */
    @Test
    public void whenNotUserByIdInDbThanShowNoUsersMassage() throws IOException {
        //init
        ValidateService serviceMemory = mock(ValidateService.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("12");
        when(request.getContextPath()).thenReturn("http://localhost:8080/item");
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(serviceMemory);
        when(serviceMemory.findById(12)).thenReturn(null);
        String noUsers =  "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<p>There is not any user with current id 12</p>"
                + " <form action='http://localhost:8080/item/list'>"
                + "     <button type='submit'>show all users</button>"
                + " </form>"
                + " </fieldset>"
                + "</body>"
                + "</html>";
        //use
        servlet.doGet(request, response);

        //check
        verify(response).setContentType("text/html");
        verify(response).getWriter();
        verify(request).getContextPath();
        verify(request).getParameter(PARAMETER_USER_ID);
        verify(request).getSession();
        verify(session).getAttribute(ATTRIBUTE_STORAGE);
        verify(writer).append(noUsers);
        verify(writer, times(1)).flush();
        verifyNoMoreInteractions(request, response, session, writer);
    }

    /**
     * The doGet's method test in the case of didn't find an user's id in request's parameters.
     * @throws IOException exception.
     */
    @Test
    public void whenNotIdInRequestThanShowNoMassage() throws IOException {
        //init
        PrintWriter writer = mock(PrintWriter.class);
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn(null);
        when(response.getWriter()).thenReturn(writer);

        //use
        servlet.doGet(request, response);

        //check
        verify(response, times(1)).setContentType("text/html");
        verify(response, times(1)).getWriter();
        verify(request, times(1)).getParameter(PARAMETER_USER_ID);
        verify(writer, times(1)).flush();
        verifyNoMoreInteractions(request, response, writer);
    }

    /**
     * The doGet's method test in the case of present an user's id in the request's parameters and user in the db.
     * @throws IOException exception.
     */
    @Test
    public void whenUserFindByIdInDbThanShowUsersField() throws IOException {
        //init
        ValidateService serviceMemory = mock(ValidateService.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("12");
        when(request.getContextPath()).thenReturn("http://localhost:8080/item");
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(serviceMemory);
        User userMock = mock(User.class);
        when(userMock.getId()).thenReturn(12);
        when(userMock.getName()).thenReturn("name");
        when(userMock.getLogin()).thenReturn("login");
        when(userMock.getEmail()).thenReturn("user@mail.ru");
        when(userMock.getCrateDate()).thenReturn(new Timestamp(System.currentTimeMillis()));
        when(serviceMemory.findById(12)).thenReturn(userMock);
        String user =  "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<p>Edit user's info into the form below</p>"
                + "<form action='http://localhost:8080/item/edit' method='post'>"
                + "  <fieldset>"
                + "    <legend>Personal user's information:</legend>"
                + "    id:   <br><input type='text' name='id' value='" + userMock.getId() + "' readonly><br>"
                + "    name: <br><input type='text' name='name' value='" + userMock.getName() + "'><br>"
                + "    login:<br><input type='text' name='login' value='" + userMock.getLogin() + "'><br>"
                + "    email:<br><input type='email' name='email' value='" + userMock.getEmail() + "'><br>"
                + "          <br><input type='submit' value='update'><br><br>"
                + " </form>"
                + " <form action='http://localhost:8080/item/list'>"
                + "     <button type='submit'>show all users</button>"
                + " </form>"
                + " </fieldset>"
                + "</body>"
                + "</html>";
        //use
        servlet.doGet(request, response);

        //check
        verify(response, times(1)).setContentType("text/html");
        verify(response, times(1)).getWriter();
        verify(request, times(2)).getContextPath();
        verify(request, times(1)).getParameter(PARAMETER_USER_ID);
        verify(request, times(1)).getSession();
        verify(session, times(1)).getAttribute(ATTRIBUTE_STORAGE);
        verify(userMock, times(2)).getId();
        verify(userMock, times(2)).getName();
        verify(userMock, times(2)).getLogin();
        verify(userMock, times(2)).getEmail();
        verify(writer, times(1)).append(user);
        verify(writer, times(1)).flush();
        verifyNoMoreInteractions(request, response, session, writer);
    }

    /**
     * The doGet's method test in the case of incorrect user's id in the request's parameters.
     * @throws IOException exception.
     */
    @Test (expected = AssertionError.class)
    public void whenUserIdInRequestIsNotNumberThanShowMassageAndLogError() throws IOException {
        //init
        PrintWriter writer = mock(PrintWriter.class);
        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("abc");
        when(request.getContextPath()).thenReturn("http://localhost:8080/item");
        when(response.getWriter()).thenReturn(writer);
        String error = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + " <form action='http://localhost:8080/item/create'>"
                + "     <button type='submit'>create new</button>"
                + " </form>"
                + "</body>"
                + "</html>";
        //use
        servlet.doGet(request, response);

        //check
        verify(response, times(1)).setContentType("text/html");
        verify(response, times(1)).getWriter();
        verify(request, times(2)).getContextPath();
        verify(request, times(1)).getParameter(PARAMETER_USER_ID);
        verify(writer, times(1)).append(error);
        verify(writer, times(1)).flush();
        assertThat(logger.getLoggingEvents(), is(asList(error("abc"))));
        verifyNoMoreInteractions(request, response, writer);
    }

//    /**
//     * The doPost's method test in the case of all data are correct.
//     * @throws IOException exception.
//     */
//    @Test
//    public void whenAllCorrectThanShowAllUsersWithUpdatedFields() throws IOException {
//        //init
//        ValidateService storage = mock(ValidateService.class);
//        PrintWriter writer = mock(PrintWriter.class);
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        when(request.getContextPath()).thenReturn("http://localhost:8080/item");
//        when(response.getWriter()).thenReturn(writer);
//        when(request.getSession()).thenReturn(session);
//        when(session.getAttribute(ATTRIBUTE_STORAGE)).thenReturn(storage);
//        when(request.getParameter(PARAMETER_USER_ID)).thenReturn("12");
//        when(request.getParameter(PARAMETER_USER_NAME)).thenReturn("name");
//        when(request.getParameter(PARAMETER_USER_LOGIN)).thenReturn("login");
//        when(request.getParameter(PARAMETER_USER_EMAIL)).thenReturn("user@mail.ru");
//        User userMock = mock(User.class);
//        when(userMock.getId()).thenReturn(12);
//        when(userMock.getName()).thenReturn("name");
//        when(userMock.getLogin()).thenReturn("login");
//        when(userMock.getEmail()).thenReturn("user@mail.ru");
//        when(userMock.getCrateDate()).thenReturn(timestamp);
//        when(storage.findById(12)).thenReturn(userMock);
//        when(userMock.getCrateDate()).thenReturn(timestamp);
//        when(storage.update(userMock)).thenReturn(true);
//        String result = "<!DOCTYPE html>"
//                + "<html>"
//                + "<body>"
//                + " <form action='http://localhost:8080/item/list'>"
//                + "     <button type='submit'>show all users</button>"
//                + " </form>"
//                + "</body>"
//                + "</html>";
//        //use
//        servlet.doPost(request, response);
//
//        //check
//        verify(response, times(1)).setContentType("text/html");
//        verify(response, times(1)).getWriter();
//        verify(request, times(1)).getContextPath();
//        verify(request, times(2)).getParameter(PARAMETER_USER_ID);
//        verify(request, times(1)).getParameter(PARAMETER_USER_NAME);
//        verify(request, times(1)).getParameter(PARAMETER_USER_LOGIN);
//        verify(request, times(1)).getParameter(PARAMETER_USER_EMAIL);
//        verify(writer, times(1)).append(result);
//        verify(writer, times(1)).flush();
//        verifyNoMoreInteractions(request, response, session, writer);
//    }
}