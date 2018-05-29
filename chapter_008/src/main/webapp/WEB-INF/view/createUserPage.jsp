<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create new user</title>
    <h3 style="text-align: center">Write user's info into the form below</h3>
</head>
<body>
<fieldset>
    <legend style="text-align: center">Personal user's information:</legend>
    <p style="font-style: italic">${userInfo}</p>
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        id:<br><input type="text" name="id"><br>
        name: <br><input type="text" name="name"><br>
        login:<br><input type="text" name="login"><br>
        email:<br><input type="email" name="email"><br>
        <br><input type="submit" value="Create"><br>
    </form>
    <form action="${pageContext.servletContext.contextPath}/allUsersList">
        <button type="submit">Show all users</button>
    </form>
</fieldset>
<p style="text-align: right">jsp version with JSTL</p>
</body>
</html>

