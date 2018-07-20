package ru.job4j.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import ru.job4j.mvc.model.entity.User;
import ru.job4j.mvc.model.logic.impl.ValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The UsersTableAjaxController class.
 */
public class UsersTableAjaxController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
