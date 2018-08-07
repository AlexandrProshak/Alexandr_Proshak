<%@ page import="ru.job4j.task1.model.logic.ValidateService" %>
<%@ page import="static ru.job4j.task1.controller.ControllerConstants.ATTRIBUTE_STORAGE" %>
<%@ page import="ru.job4j.task1.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title> Users table </title>
    <style>
        table { width:100%; }
        table, th, td { border: 2px solid black; border-collapse: collapse; }
        th, td { padding: 5px; text-align: center; }
    </style>
</head>
<body>
<div>
    <c:out value="Hello, "></c:out>
    <c:out value="${systemUser.name}"></c:out><br>
    <a href="${pageContext.servletContext.contextPath}/logout">log out</a>
</div>
<h2> Users table </h2>
<hr>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>Email</th>
        <th>Role</th>
        <th>Date</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${storage.findAll()}">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <c:choose>
                <c:when test="${systemUser.role eq 'admin'}">
                    <td><c:out value="${user.password}"></c:out></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="* * * *"></c:out></td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.role}"></c:out></td>
            <fmt:formatDate value="${user.crateDate}" pattern="d MMM yy, HH:mm" var="date"/>
            <td><c:out value="${date}"></c:out></td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/edit" method="get">
                    <button value="${user.id}" name="id" type="submit">edit</button>
                </form>
                <form action="${pageContext.servletContext.contextPath}/remove" method="post">
                    <button value="${user.id}" name="id" type="submit">remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<form action="${pageContext.servletContext.contextPath}/create">
    <button type="submit">Create new user</button>
</form>
<hr>
<footer>
    <p>Tracker © - 2018</p>
    <p>Sources on <strong><a href="https://github.com/AlexandrProshak/Alexandr_Proshak" target="_blank">GitHub</a></strong></p>
</footer>
</body>
</html>
