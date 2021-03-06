package ru.job4j.task5.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.City;
import ru.job4j.task5.model.logic.impl.ValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import static ru.job4j.task5.controller.Constants.PARAM_USER_COUNTRY;
import static ru.job4j.task5.controller.Constants.JSP_DIR;
import static ru.job4j.task5.controller.Constants.JSP_USERS;

/**
 * The FetchCitiesController class.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class FetchCitiesController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(FetchCitiesController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String countryNameParam = req.getParameter(PARAM_USER_COUNTRY.v());
            if (countryNameParam != null) {
                PrintWriter writer = resp.getWriter();
                resp.setContentType("text/json");
                resp.setCharacterEncoding("UTF-8");
                Collection<City> cities = ValidateServiceImpl.getInstance().findAllCitiesByCountry(countryNameParam);
                ObjectMapper mapper = new ObjectMapper();
                if (cities != null || !cities.isEmpty()) {
                    mapper.writeValue(writer, cities);
                    writer.flush();
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher(JSP_DIR.v() + JSP_USERS.v()).forward(req, resp);
            } catch (ServletException | IOException e1) {
                LOG.error(e.getMessage(), e1);
            }
        }
    }

}