<%@ page import="ru.job4j.task1.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Update </title>
</head>
<body>
<div >
    <c:out value="Hello, "></c:out>
    <c:out value="${systemUser.name}"></c:out><br>
    <a href="${pageContext.servletContext.contextPath}/logout">log out</a>
</div>
<h2> Update user </h2>
<hr>
<form action="${pageContext.servletContext.contextPath}/edit" method="post">
    <fieldset>
        id:<br><input id="id" name="id" type="text" value="${user.id}" readonly></br>
        name: <br><input id="name" name="name" type="text" value="${user.name}"></br>
        login:<br><input id="login" name="login" type="text" value="${user.login}"></br>
        password:<br><input id="password" name="password" type="text" value="${user.password}"></br>
        email:<br><input id="email" name="email" type="email" value="${user.email}"></br>
        role:<br><select name="role" id="role"></br>
        <c:choose>
            <c:when test="${systemUser.role eq 'admin'}">
                <option value="user">user</option>
                <option value="admin">admin</option>
            </c:when>
            <c:otherwise>
                <option value="user">user</option>
            </c:otherwise>
        </c:choose>
        </select>
        <br><input type="submit" value="update"></br>
        <br>
        <form action="${pageContext.servletContext.contextPath}/allUsersList">
            <button type="submit">Back</button>
        </form>
        <hr>
    </fieldset>
</form>
<footer>
    <p>Tracker © - 2018</p>
    <p>Sources on <strong><a href="https://github.com/AlexandrProshak/Alexandr_Proshak" target="_blank">GitHub</a></strong></p>
</footer>
</body>
</html>