<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 21.05.2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>

    function validateForm() {
        var nam = document.forms["create-form"]["name"].value;
        var log = document.forms["create-form"]["login"].value;
        var pas = document.forms["create-form"]["password"].value;
        var rol = document.forms["create-form"]["role"].value;
        var eml = document.forms["create-form"]["email"].value;
        if (nam == "" || log == "" || pas == "" || rol == "" || eml == "") {
            alert("All fields should be filled out");
            return false;
        }
    }

</script>
<head>
    <meta charset="UTF-8">
    <title> Create new user </title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
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
<h2 style="color: #1fa67b;text-align: center;">Create new user</h2>
<hr>
<form name="create-form" class="form-horizontal" action="${pageContext.servletContext.contextPath}/create" id="create-form"
      onsubmit="return validateForm()" method="post">
    <fieldset>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Name</label>
            <div class="col-md-4">
                <input type="text" name="name" id="name" class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input type="text" name="login" id="login" class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input type="password" name="password" id="password" class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input type="email" name="email" id="email" placeholder="your@email.do" class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-4">
                <select name="role" id="role" class="form-control input-md">
                    <option value="user">user</option>
                    <option value="admin">admin</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-8">
                <button class="btn btn-success" type="submit" form="create-form" value="Submit">Create</button>
                <a class="btn btn-danger" href="${pageContext.servletContext.contextPath}/allUsersList">Cancel</a>
            </div>
        </div>
    </fieldset>
</form>
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