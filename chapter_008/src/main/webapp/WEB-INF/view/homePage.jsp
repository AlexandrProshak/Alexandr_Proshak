<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>The main page for the user's management system</title>
    <h3 style="text-align: center">The main page for the user's management system</h3>
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
    <legend style="text-align: center">Same actions you can do</legend>
    <p>
    <form action="${pageContext.servletContext.contextPath}/allUsersList">
        <button type="submit">Show all users</button>
    </form>
    <form action="${pageContext.servletContext.contextPath}/create">
        <button type="submit">Create new user</button>
    </form>
    <br/>
    <form action="${pageContext.servletContext.contextPath}/logout">
        <button type="submit">Exit</button>
    </form>
    </p>
</fieldset>
<p style="text-align: right">jsp version with JSTL and filters</p>
</body>
</html>
