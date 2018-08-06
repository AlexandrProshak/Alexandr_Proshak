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
<html>
<head>
    <title>All users</title>
    <h3 style="text-align:center">All users</h3>
    <meta charset='UTF-8'>
    <style>
        table { width:100%; }
        table, th, td { border: 2px solid black; border-collapse: collapse; }
        th, td { padding: 5px; text-align: center; }
    </style>
</head>
<body>
<fieldset>
    <legend style="text-align:right">User's table</legend>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>login</th>
            <th>email</th>
            <th>date</th>
            <th>action</th>
        </tr>
        <c:forEach var="user" items="${storage.findAll()}">
            <tr>
                <td><c:out value="${user.id}"></c:out></td>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.login}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <fmt:formatDate value="${user.crateDate}" pattern="d MMM yy, HH:mm" var="date"/>
                <td><c:out value="${date}"></c:out></td>
                <td><form action="${pageContext.servletContext.contextPath}/edit" method="get">
                    <button value="${user.id}" name="id" type="submit">edit</button>
                </form>
                    <form action="${pageContext.servletContext.contextPath}/remove" method="post">
                        <button value="${user.id}" name="id" type="submit">remove</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <form action="${pageContext.servletContext.contextPath}/create">
        <button type="submit">Create new user</button>
    </form>
</fieldset>
<p style="text-align: right">jsp version with JSTL</p>
</body>
</html>