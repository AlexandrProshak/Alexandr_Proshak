package ru.job4j.task5.controller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.Role;
import ru.job4j.task5.model.entity.User;

import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.job4j.task5.controller.Constants.ATTR_SYSTEM_USER;
import static ru.job4j.task5.controller.Constants.PARAM_USER_ID;
import static ru.job4j.task5.controller.Constants.JSP_DIR;
import static ru.job4j.task5.controller.Constants.JSP_USERS;


/**
 * The filter which provide access to the operation edit according to the user role.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
     */
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
        try {
            User user = (User) req.getSession().getAttribute(ATTR_SYSTEM_USER.v());
            if (user.getRole().equals(Role.admin)) {
                chain.doFilter(req, resp);
            } else {
                int id = user.getId();
                if (id == Integer.valueOf(req.getParameter(PARAM_USER_ID.v()))) {
                    chain.doFilter(req, resp);
                } else {
                    req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                resp.sendRedirect(String.format("%s/login", req.getContextPath()));
            } catch (IOException e1) {
                LOG.error(e.getMessage(), e1);
            }
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
