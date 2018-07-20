<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AJAX Users Table</title>
    <style type="text/css">
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
        body
        {
            text-align: center;
        }
        .btn-low
        {
            background:#1fa67b;
            color:#fff;
            border:1px solid #1fa67b;
            padding: 7px 10px;
            border-radius:4px;
        }
        .btn-low:hover
        {
            text-decoration: none;
            box-shadow:3px 3px 5px #222;
            transition:box-shadow 0.2s;
        }
        .container
        {
            margin-left: auto;
            margin-right: auto;
            width: 40em;
        }
        h4
        {
            font-family: 'Oxygen', sans-serif;
            color:#1E90FF;
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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#tableDiv").hide();
            $("#showTable").click(function(event){
                $.get('usersTableAjax',function(responseJson) {
                    if(responseJson!=null){
                        $("#usersTable").find("tr:gt(0)").remove();
                        var table = $("#usersTable");
                        $.each(responseJson, function(key,value) {
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['id']);
                            rowNew.children().eq(1).text(value['name']);
                            rowNew.children().eq(2).text(value['login']);
                            rowNew.children().eq(3).text(value['password']);
                            rowNew.children().eq(4).text(value['email']);
                            rowNew.children().eq(5).text(value['role']);
                            rowNew.children().eq(6).text(value['country']);
                            rowNew.children().eq(7).text(value['city']);
                            rowNew.children().eq(8).text(value['crateDate']);
                            rowNew.appendTo(table);
                        });
                    }
                });
                $("#tableDiv").show();
            });
        });
    </script>
</head>
<body class="container">
<div style="float: right; padding-right: 15px; color: #1fa67b; font-size: medium">
    <c:out value="Hello, "></c:out>
    <c:out value="${systemUser.name}"></c:out><br>
    <a href="${pageContext.servletContext.contextPath}/logout" style="float: right; padding-right: 15px; color: #1fa67b; font-size: medium">log out</a>
</div>
<h2>AJAX Retrieve Data from Database (use JSONArray)</h2>
<input class="btn-low" type="button" value="Show users" id="showTable"/>
<br/>
<br/>
<div id="tableDiv">
    <table class="table table-striped" id="usersTable">
        <thead>
        <tr class="row-name">
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Login</th>
            <th scope="col">Password</th>
            <th scope="col">Email</th>
            <th scope="col">Role</th>
            <th scope="col">Country</th>
            <th scope="col">City</th>
            <th scope="col">Date</th>
        </tr>
        <thead>
        <tbody>

        </tbody>
    </table>
</div>
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