<%@ page import="ru.job4j.task1.logic.ValidateService" %>
<%@ page import="static ru.job4j.task1.presentation.ControllerConstants.ATTRIBUTE_STORAGE" %>
<%@ page import="ru.job4j.task1.logic.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
    <h3 style="text-align:center">All users</h3>
    <meta charset='UTF-8'>
    <style>
        table { width:100%; }
        table, th, td { border: 2px solid black; border-collapse: collapse; }
        th, td { padding: 5px; text-align: center; }
    </style>
</head>
<body>
<fieldset>
    <legend style="text-align:right">User's table</legend>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>login</th>
            <th>email</th>
            <th>date</th>
            <th>action</th>
        </tr>
        <% for (User user : ((ValidateService)session.getAttribute("storage")).findAll()) {%>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getLogin()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getCrateDate()%></td>
            <td><form action=<%=request.getContextPath()%>/edit method='get'>
                <button value=<%=user.getId()%> name='id' type='submit'>edit</button>
            </form>
                <form action=<%=request.getContextPath()%>/remove method='post'>
                    <button value='<%=user.getId()%>' name='id' type='submit'>remove</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</fieldset>
<p style="text-align: right">jsp version</p>
</body>
</html>