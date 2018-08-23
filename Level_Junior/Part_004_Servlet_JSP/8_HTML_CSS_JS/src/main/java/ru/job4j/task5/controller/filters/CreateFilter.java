package ru.job4j.task5.controller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.Role;
import ru.job4j.task5.model.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ru.job4j.task5.controller.ControllerConstants.ATTRIBUTE_SYSTEM_USER;
import static ru.job4j.task5.controller.ControllerConstants.PREFIX_PAGE;
import static ru.job4j.task5.controller.ControllerConstants.ALL_USERS_PAGE;

/**
 * The filter which provide access to the operation create according to the user role.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class CreateFilter implements Filter {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CreateFilter.class);

    /**
     * Overloaded doFilter method with http casted parameters.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @param chain FilterChain.
     */
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
        try {
            User user = (User) req.getSession().getAttribute(ATTRIBUTE_SYSTEM_USER);
            if (user.getRole().equals(Role.admin)) {
                chain.doFilter(req, resp);
            } else {
                req.getRequestDispatcher(PREFIX_PAGE + ALL_USERS_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * The init method.
     * @param filterConfig parameters.
     */
    public void init(FilterConfig filterConfig) {

    }

    /**
     * The general method doFilter.
     * @param req ServletRequest.
     * @param resp ServletResponse.
     * @param chain FilterChain.
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {
        doFilter((HttpServletRequest) req, (HttpServletResponse) resp, chain);
    }

    /**
     * The destroy method.
     */
    public void destroy() {

    }
}
