package ru.job4j.mvc.controller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.mvc.model.entity.Role;
import ru.job4j.mvc.model.entity.User;

import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.job4j.mvc.controller.ControllerConstants.ATTRIBUTE_SYSTEM_USER;
import static ru.job4j.mvc.controller.ControllerConstants.PARAMETER_USER_ID;
import static ru.job4j.mvc.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.mvc.controller.ControllerConstants.ALL_USERS_PAGE;

/**
 * The filter which provide access to the operation edit according to the user role.
 */
public class EditFilter implements Filter {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EditFilter.class);

    /**
     * Overloaded doFilter method with http casted parameters.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @param chain FilterChain.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            User user = (User) req.getSession().getAttribute(ATTRIBUTE_SYSTEM_USER);
            if (user.getRole().equals(Role.admin)) {
                chain.doFilter(req, resp);
            } else {
                int id = user.getId();
                if (id == Integer.valueOf(req.getParameter(PARAMETER_USER_ID))) {
                    chain.doFilter(req, resp);
                } else {
                    req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            resp.sendRedirect(String.format("%s/login", req.getContextPath()));
        }
    }

    /**
     * The init method.
     * @param filterConfig parameters.
     * @throws ServletException exception.
     */
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * The general method doFilter.
     * @param req ServletRequest.
     * @param resp ServletResponse.
     * @param chain FilterChain.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        doFilter((HttpServletRequest) req, (HttpServletResponse) resp, chain);
    }

    /**
     * The destroy method.
     */
    public void destroy() {

    }
}
