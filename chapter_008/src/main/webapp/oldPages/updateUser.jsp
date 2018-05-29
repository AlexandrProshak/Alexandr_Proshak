<%@ page import="ru.job4j.crudservlet.logic.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
    <h3 style="text-align: center">Edit user's info into the form below</h3>
</head>
<body>
<fieldset>
    <legend>Personal user's information:</legend>
    <form action=<%=request.getContextPath()%>/edit method="post">
        id:<br><input type="text" name="id" value="<%=((User) request.getAttribute("user")).getId()%>" readonly><br>
        name: <br><input type="text" name="name" value="<%=((User) request.getAttribute("user")).getName()%>"><br>
        login:<br><input type="text" name="login" value="<%=((User) request.getAttribute("user")).getLogin()%>"><br>
        email:<br><input type="email" name="email" value="<%=((User) request.getAttribute("user")).getEmail()%>"><br>
        <br><input type="submit" value="update"><br>
    </form>
    <form action=<%=request.getContextPath()%>/list>
        <button type="submit">show all users</button>
    </form>
</fieldset>
<p style="text-align: right">jsp version</p>
</body>
</html>