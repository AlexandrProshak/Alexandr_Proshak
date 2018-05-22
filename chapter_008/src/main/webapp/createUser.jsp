<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
    <h3 style="text-align: center">Write user's info into the form below</h3>
</head>
<body>
<fieldset>
    <legend style="text-align: center">Personal user's information:</legend>
    <%if (request.getAttribute("userInfo") == null) {
        request.setAttribute("userInfo", "Creating new user ...");
    }%>
    <p style="font-style: italic"><%=request.getAttribute("userInfo")%></p>
    <form action=<%=request.getContextPath()%>/create method='post'>
        id:<br><input type='text' name='id'><br>
        name: <br><input type='text' name='name'><br>
        login:<br><input type='text' name='login'><br>
        email:<br><input type='email' name='email'><br>
        <br><input type='submit' value='create'><br>
    </form>
    <form action=<%=request.getContextPath()%>/list>
        <button type='submit'>show all users</button>
    </form>
</fieldset>
<p style="text-align: right">jsp version</p>
</body>
</html>

