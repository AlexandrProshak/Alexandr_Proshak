<%@ page import="ru.job4j.task5.model.logic.ValidateService" %>
<%@ page import="static ru.job4j.task5.controller.ControllerConstants.ATTRIBUTE_STORAGE" %>
<%@ page import="ru.job4j.task5.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" scope="request" value="${pageContext.request.contextPath}"/>

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
        <c:set var="user_id" scope="session"/>
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
                            <form action="${context}/edit" method="post">
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
    <button id="user-create-button" class="btn btn-success btn-md"
            data-toggle="modal" data-target="#user-create-modal-dialog">Create user
    </button>
    <div id="tableDiv">
        <table class="table table-striped" id="usersTable" style="font-size: small">
            <thead>
            <tr class="row-name">
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Login</th>
                <th scope="col">Password</th>
                <%--<th scope="col">Email</th>--%>
                <%--<th scope="col">Role</th>--%>
                <%--<th scope="col">Country</th>--%>
                <%--<th scope="col">City</th>--%>
                <%--<th scope="col">Date</th>--%>
            </tr>
            <thead>
            <tbody>

            </tbody>
        </table>
    </div>

</div>
