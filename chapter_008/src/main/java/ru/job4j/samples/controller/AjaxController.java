package ru.job4j.samples.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxController extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
//        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        writer.write("Hello " + name);
        writer.flush();
    }
}
