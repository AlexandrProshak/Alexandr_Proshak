<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 30.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
</head>
<body>
<h3> Log in </h3>
<section>
    <hr>
    <p>test user-guest/guest</p>
    <form action="${pageContext.servletContext.contextPath}/login" method="post" autocomplete="off">
        login:<br><input type="text" name="login" id="login" placeholder="Login"></br>
        password:<br><input type="password" name="password" id="password" placeholder="Password"></br>
        <br><input type="submit" value="Log in">
    </form>
    <hr>
</section>
<footer>
    <p>Tracker © - 2018</p>
    <p>Sources on <strong><a href="https://github.com/AlexandrProshak/Alexandr_Proshak" target="_blank">GitHub</a></strong></p>
</footer>
</body>
</html>