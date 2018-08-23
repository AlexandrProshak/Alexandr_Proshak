<%@ page import="ru.job4j.task5.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
    function validateLogin() {
        var loginParam = document.getElementById("login").value;
        $.ajax('./checkLogin?loginParam=' + loginParam, {
            method: 'get',
            complete: function (data) {
                if (data.responseText =="free") {
                    return true;
                } else {
                    alert("User with login " + loginParam + " already used");
                    return false;
                }
            }
        })
    }

    function validateEmail() {
        var emailParam = document.getElementById("email").value;
        $.ajax('./checkEmail?emailParam=' + emailParam, {
            method: 'get',
            complete: function (data) {
                if (data.responseText =="free") {
                    return true;
                } else {
                    alert("User with login " + emailParam + " already used");
                    return false;
                }
            }
        })
    }

    function updateCitiesByCountry() {
        var country = document.getElementById("country-opt").value;
        $.ajax('./cities?country=' + country, {
            method: 'get',
            complete: function (data) {
                var cities = JSON.parse(data.responseText);
                for(var i = 0; i < cities.length; ++i) {
                    document.getElementById("city-opt").options[i] = new Option(cities[i].name, cities[i].name);
                }
            }
        })
    }

    function validateForm() {
        var nam = document.forms["form"]["name"].value;
        var log = document.forms["form"]["login"].value;
        var pas = document.forms["form"]["password"].value;
        var rol = document.forms["form"]["role"].value;
        var eml = document.forms["form"]["email"].value;
        if (nam == "" || log == "" || pas == "" || rol == "" || eml == "") {
            alert("All fields should be filled out");
            return false;
        }
    }
</script>
<head>
    <meta charset="UTF-8">
    <title> Update </title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        .btn-danger:hover
        {
            background: #de6c69;
        }
        .btn-danger
        {
            background:#d9534f;
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
    <c:out value="${pageContext.servletContext.contextPath}"></c:out><br>
    <a href="http://localhost:8080/item/logout" style="float: right; padding-right: 15px; color: #1fa67b; font-size: medium">log out</a>
</div>
<h2 style="color: #1fa67b;text-align: center;"> Update user </h2>
<hr>
<form class="form-horizontal" action="http://localhost:8080/item/edit" method="post" id="form"
      onsubmit="return validateForm()">
    <fieldset>
        <div class="form-group">
            <label class="col-md-4 control-label" for="id">Id</label>
            <div class="col-md-4">
                <input id="id" name="id" type="text" value="${user.id}"
                       class="form-control input-md" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Name</label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" value="${user.name}"
                       class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" value="${user.login}"
                       class="form-control input-md" required oninput="validateLogin()">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="password" type="text" value="${user.password}"
                       class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input id="email" name="email" type="email" value="${user.email}"
                       class="form-control input-md" required oninput="validateEmail()">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-4">
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
            <label class="col-md-4 control-label" for="country-opt">Country</label>
            <div class="col-md-4">
                <select id="country-opt" class="form-control" name="country" required onchange="updateCitiesByCountry()">
                    <c:forEach var="country" items="${requestScope.countries}">
                        <option>${country.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="city-opt">City</label>
            <div class="col-md-4">
                <select id="city-opt" class="form-control" name="city" required></select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-8" style="float: right">
                <button id="button1id" class="btn btn-success" type="submit" form="form" value="Submit">Update</button>
                <a class="btn btn-danger" href="${pageContext.servletContext.contextPath}/allUsersList">Back</a>
            </div>
        </div>
        <hr>
    </fieldset>
</form>
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