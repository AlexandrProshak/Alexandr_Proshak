<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title> Create new user </title>
</head>
<body>
<div>
    <c:out value="Hello, "></c:out>
    <c:out value="${systemUser.name}"></c:out><br>
    <a href="${pageContext.servletContext.contextPath}/logout">log out</a>
</div>
<h2>Create new user</h2>
<hr>
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    <fieldset>
        name:<br><input type="text" name="name" id="name"></br>
        login:<br><input type="text" name="login" id="login"></br>
        password:<br><input type="password" name="password" id="password" autocomplete="off" required></br>
        email:<br><input type="email" name="email" id="email"></br>
        role:<br><select name="role" id="role"></br>
            <option value="user">user</option>
            <option value="admin">admin</option>
        </select></br>
        <br><button type="submit" value="Submit">Create</button></br>
        <br>
       </fieldset>
</form>
<form action="${pageContext.servletContext.contextPath}/allUsersList">
    <button type="submit">Back</button>
</form>
<hr>
<footer>
    <p>Tracker © - 2018</p>
    <p>Sources on <strong><a href="https://github.com/AlexandrProshak/Alexandr_Proshak" target="_blank">GitHub</a></strong></p>
</footer>
</body>
</html>