<%@ page import="ru.job4j.task1.model.entity.User" %><%--
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
</head>
<body>
<fieldset>
    <legend>Personal user's information:</legend>
    <form action="${pageContext.servletContext.contextPath}/edit" method="post">
        id:<br><input type="text" name="id" value="${user.id}" readonly><br>
        name: <br><input type="text" name="name" value="${user.name}"><br>
        login:<br><input type="text" name="login" value="${user.login}"><br>
        email:<br><input type="email" name="email" value="${user.email}"><br>
        <br><input type="submit" value="update"><br>
    </form>
    <form action="${pageContext.servletContext.contextPath}/allUsersList">
        <button type="submit">show all users</button>
    </form>
</fieldset>
<p style="text-align: right">jsp version with JSTL</p>
</body>
</html>