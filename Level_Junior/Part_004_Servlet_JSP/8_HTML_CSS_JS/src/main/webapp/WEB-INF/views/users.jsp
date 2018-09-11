<%@ page import="ru.job4j.task5.model.logic.ValidateService" %>
<%@ page import="static ru.job4j.task5.controller.Constants.ATTR_STORAGE" %>
<%@ page import="ru.job4j.task5.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" scope="request" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title> Users table </title>
    <c:import url="page-parts/meta-inf.jsp"/>
    <c:import url="page-parts/style/css.jsp"/>
    <c:import url="scripts/user_create_validation.jsp"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${context}/">Tracker</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${context}/allUsersList">All Users</a></li>
            <li><a href="${context}/create">Create new</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${context}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="panel panel-info">
    <div class="panel-body">&nbsp</div>
    <div class="panel-footer" style="text-align: right">
        Logged user id:&nbsp${systemUser.id}, name:&nbsp${systemUser.name}, role:&nbsp${systemUser.role}
    </div>
</div>
<div class="container">
    <table id="user_table" class="table table-striped table-hover table-bordered table-condensed table-responsive">
        <thead>
        <tr class="row-name active" style="font-size: medium">
            <th>Identity</th>
            <th>Credentials</th>
            <th>Info</th>
            <th style="text-align: center">Actions:</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${storage.findAll()}">
            <tr class="row-content" style="font-size: small">
                <td>
                    <div><b>Id: </b><c:out value="${user.id}"></c:out></div>
                    <div>
                        <fmt:formatDate value="${user.crateDate}" pattern="d MMM yy, HH:mm" var="date"/>
                        <b>Created: </b><c:out value="${date}"></c:out></div>
                </td>
                <td>
                    <div><b>Login: </b><c:out value="${user.login}"></c:out></div>
                    <c:choose>
                        <c:when test="${systemUser.role eq 'admin'}">
                            <div><b>Password: </b><c:out value="${user.password}"></c:out></div>
                        </c:when>
                        <c:otherwise>
                            <div><b>Password: </b><c:out value="* * * *"></c:out></div>
                        </c:otherwise>
                    </c:choose>
                    <div><b>Role: </b><c:out value="${user.role}"></c:out></div>
                </td>
                <td>
                    <div><b>Name: </b><c:out value="${user.name}"></c:out></div>
                    <div><b>Email: </b><c:out value="${user.email}"></c:out></div>
                    <div><b>Country: </b><c:out value="${user.country}"></c:out></div>
                    <div><b>City: </b><c:out value="${user.city}"></c:out></div>
                </td>
                <td style="text-align: center">
                    <div class="row" style="margin-top: 8%">
                        <div class="col-sm-6">
                            <form action="${context}/edit" method="get">
                                <button class="btn btn-info edit" value="${user.id}" name="id" type="submit">edit</button>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <form action="${context}/remove" method="post">
                                <button class="btn btn-danger" value="${user.id}" name="id" type="submit">remove</button>
                            </form>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<c:import url="page-parts/footer.jsp"/>
</body>
</html>
