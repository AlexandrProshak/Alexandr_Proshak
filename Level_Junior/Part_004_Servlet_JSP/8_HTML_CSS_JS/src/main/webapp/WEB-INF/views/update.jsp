<%@ page import="ru.job4j.task5.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" scope="request" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title> Update user </title>
    <c:import url="page-parts/meta-inf.jsp"/>
    <c:import url="page-parts/style/css.jsp"/>
    <c:import url="scripts/user_common_validation.jsp"/>
    <c:import url="scripts/user_update_validation.jsp"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${context}/">Tracker</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${context}/allUsersList">All Users</a></li>
            <li><a href="${context}/create">Create new</a></li>
            <li class="active"><a href="#">Update user</a></li>
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
    <form action="${context}/edit" method="post" class="form-horizontal" id="form-upd"
          onsubmit="return validateUpdateForm()">
        <div class="form-group">
            <label class="control-label col-sm-2" for="id">Id</label>
            <div class="col-sm-10">
                <input id="id" name="id" type="text" value="${user.id}"
                       class="form-control input-md" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name</label>
            <div class="col-sm-10">
                <input id="name" name="name" type="text" value="${user.name}"
                       class="form-control input-md">
                <span class="alert alert-danger col-sm-12"
                      id="err-name">Should Contain Only Characters</span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="login">Login</label>
            <div class="col-sm-10">
                <input id="old-login" value="${user.login}" hidden>
                <input id="login" name="login" type="text" value="${user.login}"
                       class="form-control input-md">
                <span class="alert alert-danger col-sm-12"
                      id="err-login">Should Contain Only Characters</span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password"
                       name="password" placeholder="Enter Password">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="cpassword">Confirm password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="cpassword"
                       name="password" placeholder="Enter Password">
                <span class="alert alert-danger col-sm-12"
                      id="err-pass">Should Match the passwords</span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email</label>
            <div class="col-sm-10">
                <input id="old-email" value="${user.email}" hidden>
                <input id="email" name="email" type="email" value="${user.email}"
                class="form-control input-md">
                <span class="alert alert-danger col-sm-12"
                      id="err-email">Invalid Email Address</span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="role">Role</label>
            <div class="col-sm-10">
                <select name="role" id="role" class="form-control input-md" required>
                    <c:choose>
                        <c:when test="${systemUser.role eq 'admin'}">
                            <option value="user">user</option>
                            <option value="admin">admin</option>
                        </c:when>
                        <c:otherwise>
                            <option value="user">user</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="country-opt">Country</label>
            <div class="col-sm-10">
                <select id="country-opt" class="form-control" name="country"
                        required onchange="updateCitiesByCountry()">
                    <option>...</option>
                    <c:forEach var="country" items="${sessionScope.countries}">
                        <option>${country.name}</option>
                    </c:forEach>
                </select>
                <span class="alert alert-danger col-sm-12"
                      id="err-country">Must select the country</span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="city-opt">City</label>
            <div class="col-sm-10">
                <select id="city-opt" class="form-control" name="city"
                        required></select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2">
                <input type="submit" class="btn btn-success" value="Update">
            </div>
        </div>
    </form>
</div>
<c:import url="page-parts/footer.jsp"/>
</body>
</html>