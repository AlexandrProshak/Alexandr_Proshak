<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 30.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>

    function showPassword() {
        var key_attr = $('#password').attr('type');
        if(key_attr != 'text') {
            $('.checkbox').addClass('show');
            $('#password').attr('type', 'text');
        } else {
            $('.checkbox').removeClass('show');
            $('#password').attr('type', 'password');
        }
    }

    function validateForm() {
        var log = document.forms["login-form"]["login"].value;
        var pass = document.forms["login-form"]["password"].value;
        if (log == "" || pass == "") {
            alert("Login and password, both should be filled out");
            return false;
        }
    }

</script>
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>

        /*--------- Login Section ---------*/

        #login_section .form-wrap {
            width: 30%;
            margin: 0 auto;
        }
        #login_section h1 {
            color: #1fa67b;
            font-size: 18px;
            text-align: center;
            font-weight: bold;
            padding-bottom: 20px;
        }
        #login_section .form-group {
            margin-bottom: 25px;
        }
        #login_section .checkbox {
            margin-bottom: 20px;
            position: relative;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            -o-user-select: none;
            user-select: none;
        }
        #login_section .checkbox.show:before {
            content: '\e013';
            color: #1fa67b;
            font-size: 17px;
            margin: 1px 0 0 3px;
            position: absolute;
            pointer-events: none;
            font-family: 'Glyphicons Halflings';
        }
        #login_section .checkbox .character-checkbox {
            width: 25px;
            height: 25px;
            cursor: pointer;
            border-radius: 3px;
            border: 1px solid #ccc;
            vertical-align: middle;
            display: inline-block;
        }
        #login_section .checkbox .label {
            color: #6d6d6d;
            font-size: 13px;
            font-weight: normal;
        }
        #login_section .btn.btn-custom {
            font-size: 14px;
            margin-bottom: 20px;
        }

        /*--------- Inputs & Buttons ---------*/

        .form-control {
            color: #212121;
        }
        .btn-custom {
            color: #fff;
            background-color: #1fa67b;
        }
        .btn-custom:hover,
        .btn-custom:focus {
            color: #fff;
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
<h3 style="color: #1fa67b; text-align: center; margin-top: 3%"> Log in </h3>
<section id="login_section">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="form-wrap">
                    <hr>
                    <p style="text-align: center">test user - guest / guest</p>
                    <form name="login-form" action="${pageContext.servletContext.contextPath}/login"
                          onsubmit="return validateForm()" method="post" autocomplete="off">
                        <div class="form-group">
                            <label for="login" class="sr-only">Login</label>
                            <input type="text" name="login" id="login" class="form-control" placeholder="Login">
                        </div>
                        <div class="form-group">
                            <label for="password" class="sr-only">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <span class="character-checkbox" onclick="showPassword()"></span>
                            <span class="label">Show password</span>
                        </div>
                        <input type="submit" id="btn-login" class="btn btn-low btn-custom btn-lg btn-block" value="Log in">
                    </form>
                    <hr>
                </div>
            </div> <!-- /.col-xs-12 -->
        </div> <!-- /.row -->
    </div> <!-- /.container -->
</section>
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