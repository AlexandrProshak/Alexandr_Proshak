<%@ page import="ru.job4j.task5.model.logic.ValidateService" %>
<%@ page import="static ru.job4j.task5.controller.ControllerConstants.ATTRIBUTE_STORAGE" %>
<%@ page import="ru.job4j.task5.model.entity.User" %><%--
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
    <title> Users table </title>
    <c:import url="page-parts/meta-inf.jsp"/>
    <c:import url="page-parts/style/css.jsp"/>
    <c:import url="scripts/user_create_validation.jsp"/>
</head>
<body>
<c:import url="page-parts/navbar.jsp"/>
<div class="panel panel-info">
    <div class="panel-body">&nbsp</div>
    <div class="panel-footer" style="text-align: right">
        Logged user id:&nbsp${systemUser.id}, name:&nbsp${systemUser.name}, role:&nbsp${systemUser.role}
    </div>
</div>

<%--<div class="container-fluid">--%>
            <%--<span class="alert alert-success col-lg-8 col-md-8 col-sm-8 col-xs-12"--%>
                  <%--style="text-align: center" id="alertSuccess">--%>
                <%--Hey! ${systemUser.name}, you have successfully created new user</span>--%>
<%--</div>--%>

<c:import url="page-parts/users-table.jsp"/>
<c:import url="page-parts/user-create-modal-dialog.jsp"/>
<c:import url="page-parts/footer.jsp"/>
</body>
</html>
