<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 24.04.2020
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
    <style>
        .center {
            margin-left: 40%;
            margin-top: 19%;
        }
    </style>
</head>
<body>
<div class="center">
    Authentication:
    <br>
    <form action="/security">
        <input required type="text" name="login" placeholder="Login">
        <input required type="password" name="password" placeholder="Password">
        <input type="submit" value="Sign">
    </form>
</div>
</body>
</html>
