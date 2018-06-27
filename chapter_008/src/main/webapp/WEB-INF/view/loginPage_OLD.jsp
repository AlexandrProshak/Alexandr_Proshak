<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 30.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign in</title>
    <h3 style="text-align: center">Authorization page</h3>
</head>
<body>
<fieldset>
    <c:if test="${error != ''}">
        <div style="background-color: red">
            <c:out value="${error}"></c:out>
        </div>
    </c:if>
    <legend style="text-align: center">Insert login and password</legend>
    <form action="${pageContext.servletContext.contextPath}/login" method="post">
        login:<br><input type="text" name="login"><br>
        password:<br><input type="password" name="password"><br>
        <br><input type="submit" value="Log in"><br>
    </form>
</fieldset>
<p style="text-align: right">jsp version with JSTL and filters</p>
</body>
</html>

