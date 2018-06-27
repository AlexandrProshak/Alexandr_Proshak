<%--
  Created by IntelliJ IDEA.
  User: Proshak
  Date: 26.06.2018
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajax sample</title>
    <script src="//code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script type="text/javascript">

        $(document).ready(function() {
            $('#button').click(function() {
                $.ajax({
                    type : 'POST',
                    url : 'ajax',
                    data : {
                        name : $('#userName').val()
                    },
                    success : function(responseText) {
                        $('#ajaxResult').text(responseText);
                    }
                });
            });
        });

    </script>
</head>
<body>

<form>
    Name: <input type="text" id="userName">
    <input type="button" value="send" id="button"></input>
</form>
<br>
<br>
<div id="ajaxResult"></div>
</body>
</html>
