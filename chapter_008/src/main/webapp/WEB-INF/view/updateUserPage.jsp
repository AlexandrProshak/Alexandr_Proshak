<%@ page import="ru.job4j.crudservlet.logic.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update user</title>
    <h3 style="text-align: center">Edit user's info into the form below</h3>
    <h4 style="text-align:right">
        <div style="background-color: lightslategrey">
            <c:out value="Current user: "></c:out><br>
            <c:out value="login : "></c:out>
            <c:out value="${systemUser.login}"></c:out><br>
            <c:out value="role: "></c:out>
            <c:out value="${systemUser.role}"></c:out>
        </div>
    </h4>
</head>
<body>
<fieldset>
    <legend>Personal user's information:</legend>
    <c:if test="${systemUser.role eq 'admin'}">
    <form action="${pageContext.servletContext.contextPath}/edit" method="post">
        id:<br><input type="text" name="id" value="${user.id}" readonly><br>
        name: <br><input type="text" name="name" value="${user.name}"><br>
        login:<br><input type="text" name="login" value="${user.login}"><br>
        password:<br><input type="password" name="password" value="${user.password}"><br>
        email:<br><input type="email" name="email" value="${user.email}"><br>
        role:<br><select name="role">
                        <option value="user">user</option>
                        <option value="admin">admin</option>
                    </select><br>
        <br><input type="submit" value="update"><br>
    </form>
    </c:if>
    <c:if test="${systemUser.role eq 'user'}">
        <form action="${pageContext.servletContext.contextPath}/edit" method="post">
            id:<br><input type="text" name="id" value="${user.id}" readonly><br>
            name: <br><input type="text" name="name" value="${user.name}"><br>
            login:<br><input type="text" name="login" value="${user.login}"><br>
            password:<br><input type="password" name="password" value="${user.password}"><br>
            email:<br><input type="email" name="email" value="${user.email}"><br>
            role:<br><select name="role">
                            <option value="user">user</option>
                        </select><br>
            <br><input type="submit" value="update"><br>
        </form>
    </c:if>
    <form action="${pageContext.servletContext.contextPath}/allUsersList">
        <button type="submit">show all users</button>
    </form>
    <br/>
    <form action="${pageContext.servletContext.contextPath}/logout">
        <button type="submit">Exit</button>
    </form>
</fieldset>
<p style="text-align: right">jsp version with JSTL and filters</p>
</body>
</html>