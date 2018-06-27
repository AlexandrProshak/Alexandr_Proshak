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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>.
<script>

    // function editUser() {
    //     var a = document.getElementById("idToAct").value;
    //
    //
    //     }
    // }

    function removeUser() {
        $.ajax('./remove', {
            type : 'post',
            data : 'id=' + document.getElementById('idToAct').val()
        })
    }


</script>
<head>
    <meta charset="UTF-8">
    <title> Users table </title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>

        /*--------- Users table Section ---------*/

        a.del
        {
            background:#d9534f;
            border-radius: 2px;
            width: 35px;
            height:28px;
            padding-left:12px;
            line-height:10px;
        }

        a.edit
        {
            padding-left:10px;
            background:#337ab7;
            color:#fff;
            border-radius:2px;
            border:none;
        }

        tr.row-name
        {
            font-size: 16px;
            color:#1fa67b;
        }

        tr.row-content
        {
            color:#6c7173;
        }

        table
        {
            border-bottom: 8px solid #1fa67b;
        }

        td.check
        {
            text-align: center;
        }

        .table-striped>tbody>tr:nth-of-type(odd)
        {
            background:#F0F2F2 !important;
        }

        a.btn-danger:hover
        {
            background: #de6c69;
        }

        a.btn-danger
        {
            background:#d9534f;
        }

        a.btn-low
        {
            float: right;
            background:#1fa67b;
            color:#fff;
            border:1px solid #1fa67b;
            padding: 7px 10px;
            border-radius:4px;
        }

        a.btn-low:hover
        {
            text-decoration: none;
            box-shadow:3px 3px 5px #222;
            transition:box-shadow 0.2s;
        }

        /*--------- Footer ---------*/

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
    <a href="http://localhost:8080/item/logout" style="float: right; padding-right: 15px; color: #1fa67b; font-size: medium">log out</a>
</div>
<h2 style="color: #1fa67b;text-align: center;"> Users table </h2>
<hr>
<c:if test="${systemUser.role eq 'admin'}">
<table class="table table-striped">
    <thead>
    <tr class="row-name">
        <th>Id</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>Email</th>
        <th style="width:10%">Role</th>
        <th>Date</th>
        <th>Settings</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${storage.findAll()}">
        <tr class="row-content">
            <c:set var="idToAct" scope="session" value="${user.id}"/>
            <td>${idToAct}</td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.role}"></c:out></td>
            <fmt:formatDate value="${user.crateDate}" pattern="d MMM yy, HH:mm" var="date"/>
            <td><c:out value="${date}"></c:out></td>
            <td>
                <a class="btn btn-danger edit" onclick="return removeUser()" aria-label="Settings" target="remove">
                    <i class="fa fa-trash" aria-hidden="true"></i>
                </a>
                &nbsp
                <a class="btn btn-info edit" onclick="" aria-label="Settings" target="edit">
                    <i class="fa fa-pencil-square-o" aria-hidden="true" ></i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
<c:if test="${systemUser.role eq 'user'}">
    <table class="table table-striped">
        <thead>
        <tr class="row-name">
            <th>Id</th>
            <th>Name</th>
            <th>Login</th>
            <th>Email</th>
            <th style="width:10%">Role</th>
            <th>Date</th>
            <th>Settings</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${storage.findAll()}">
            <tr class="row-content">
                <c:set var="idToAct" scope="session" value="${user.id}"/>
                <td>${idToAct}</td>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.login}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.role}"></c:out></td>
                <fmt:formatDate value="${user.crateDate}" pattern="d MMM yy, HH:mm" var="date"/>
                <td><c:out value="${date}"></c:out></td>
                <td>
                    <a class="btn btn-danger edit" onclick="editUser()" aria-label="Settings" target="edit">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
                    &nbsp
                    <a class="btn btn-info edit" onclick="removeUser()" aria-label="Settings" target="remove">
                        <i class="fa fa-pencil-square-o" aria-hidden="true" ></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<div class="dropdown">
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
