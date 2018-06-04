<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Empty storage</title>
    <h3 style="text-align: center">There are no any users yet</h3>
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
    <legend style="text-align: center">To create new user press the button "Create new user"</legend>
    <p>
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
