<%@ page import="ru.job4j.crudservlet.logic.ValidateService" %>
<%@ page import="static ru.job4j.jsp.presentation.UsersServlet.ATTRIBUTE_STORAGE" %>
<%@ page import="ru.job4j.crudservlet.logic.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title> Users table </title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>.
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        table
        {
            border-bottom: 8px solid #1fa67b;
        }
        tr.row-name
        {
            font-size: 14px;
            color:#1fa67b;
        }
        tr.row-content
        {
            color:#6c7173;
        }
        .table-striped>tbody>tr:nth-of-type(odd)
        {
            background:#F0F2F2 !important;
        }
        .btn-low
        {
            float: right;
            background:#1fa67b;
            color:#fff;
            border:1px solid #1fa67b;
            padding: 7px 10px;
            border-radius:4px;
            margin-right: 10%;
        }
        a.btn-low:hover
        {
            text-decoration: none;
            box-shadow:3px 3px 5px #222;
            transition:box-shadow 0.2s;
        }
        .container
        {
            margin-left: auto;
            margin-right: auto;
            width: 50%;
        }
        #footer {
            color: #6d6d6d;
            font-size: 12px;
            text-align: center;
        }
        #footer p {
            margin-bottom: 0;
        }
        #footer a {
            color: inherit;
        }
    </style>
</head>
<body>
<div style="float: right; padding-right: 15px; color: #1fa67b; font-size: medium">
    <c:out value="Hello, "></c:out>
    <c:out value="${systemUser.name}"></c:out><br>
    <a href="${pageContext.servletContext.contextPath}/logout" style="float: right; padding-right: 15px; color: #1fa67b; font-size: medium">log out</a>
</div>
<h2 style="color: #1fa67b;text-align: center;"> Users table </h2>
<hr>
<table class="table table-striped">
    <thead>
    <tr class="row-name">
        <th>Id</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>Email</th>
        <th>Role</th>
        <th>Country</th>
        <th>City</th>
        <th>Date</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${storage.findAll()}">
        <tr class="row-content">
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <c:choose>
                <c:when test="${systemUser.role eq 'admin'}">
                    <td><c:out value="${user.password}"></c:out></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="* * * *"></c:out></td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.role}"></c:out></td>
            <td><c:out value="${user.country}"></c:out></td>
            <td><c:out value="${user.city}"></c:out></td>
            <fmt:formatDate value="${user.crateDate}" pattern="d MMM yy, HH:mm" var="date"/>
            <td><c:out value="${date}"></c:out></td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/edit" method="get">
                    <button class="btn btn-danger edit" value="${user.id}" name="id" type="submit">edit</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/remove" method="post">
                    <button class="btn btn-info edit" value="${user.id}" name="id" type="submit">remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <a class="btn-low" href="${pageContext.servletContext.contextPath}/create">
        <i class="fa fa-plus" aria-hidden="true"></i>&nbsp Create new user
    </a>
    <br>
</div>
<br>
<hr>
<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <p>Tracker © - 2018</p>
                <p>Sources on <strong><a href="https://github.com/AlexandrProshak/Alexandr_Proshak" target="_blank">GitHub</a></strong></p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
