<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 30.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>

    <c:import url="page-parts/meta-inf.jsp"/>
    <c:import url="page-parts/style/css.jsp"/>

    <!-- Login validate script -->
    <c:import url="scripts/login_validation.jsp"/>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${context}/">Tracker</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <div class="nav navbar-nav navbar-right">
            <div style="margin-top: 12%">
                <button class="btn btn-success" data-toggle="modal"
                        data-target="#user-login-modal-dialog" style="margin-right: 10px">Login</button>
            </div>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <h2>Welcome to our user tracker system.</h2>
        <p>For enjoying press the button continue, enter your login & password and have fun.</p>
        <span>test user login/password - guest/guest</span></br></br>
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#user-login-modal-dialog">Continue &raquo;</button>
    </div>
</div>
<!-- Modal login window -->
<c:import url="page-parts/user-login-modal-dialog.jsp"/>
<!-- Footer -->
<c:import url="page-parts/footer.jsp"/>
</body>
</html>