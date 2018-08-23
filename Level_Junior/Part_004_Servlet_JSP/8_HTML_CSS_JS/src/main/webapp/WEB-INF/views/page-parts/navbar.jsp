<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="context" scope="request" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${context}/">Tracker</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">All Users</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${context}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>