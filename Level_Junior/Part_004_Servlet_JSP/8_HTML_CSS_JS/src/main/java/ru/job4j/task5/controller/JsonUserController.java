package ru.job4j.task5.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.task5.model.entity.City;
import ru.job4j.task5.model.entity.Country;
import ru.job4j.task5.model.entity.User;
import ru.job4j.task5.model.logic.impl.ValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class JsonUserController extends HttpServlet {

    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(JsonUserController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            StringBuilder result = new StringBuilder();
            BufferedReader reader = req.getReader();
            if (reader != null) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(result.toString(), User.class);
            if (isValid(user)) {
                if (ValidateServiceImpl.getInstance().add(user)) {
                    Collection<User> all = ValidateServiceImpl.getInstance().findAll();
                    ArrayList<User> users = new ArrayList<>(all);
                    Gson gson = new Gson();
                    JsonElement element = gson.toJsonTree(users, new TypeToken<List<User>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    resp.setContentType("application/json");
                    resp.getWriter().print(jsonArray);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

    }

    /**
     * The method check input user's personal data.
     * @param user to validate.
     * @return true if all data are valid.
     */
    private boolean isValid(User user) {
        boolean result = true;
        Collection<User> users = ValidateServiceImpl.getInstance().findAll();
        List<String> loginList = new LinkedList<>();
        List<String> emailList = new LinkedList<>();
        List<String> countryList = new LinkedList<>();
        List<String> cityList = new LinkedList<>();
        Collection<Country> allCountries = ValidateServiceImpl.getInstance().findAllCountries();
        for (Country each: allCountries) {
            countryList.add(each.getName());
        }
        if (!countryList.contains(user.getCountry())) {
            return false;
        }
        Collection<City> allCitiesByCountry = ValidateServiceImpl.getInstance().findAllCitiesByCountry(user.getCountry());
        for (City each: allCitiesByCountry) {
            cityList.add(each.getName());
        }
        if (!cityList.contains(user.getCity())) {
            return false;
        }
        for (User each: users) {
            loginList.add(each.getLogin());
            emailList.add(each.getEmail());
        }
        if (loginList.contains(user.getLogin())
                || user.getPassword().length() == 0
                || emailList.contains(user.getEmail())) {
            result = false;
        }
        return result;
    }
}
