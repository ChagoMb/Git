<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 24.04.2020
  Time: 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form action="/add" method="post">
    <input required type="text" name="name" placeholder="Name">
    <input required type="text" name="email" placeholder="e-mail">
    <input required type="text" name="password" placeholder="Password">
    <input required type="text" name="acc" placeholder="Acc">
    <input required type="text" name="role" placeholder="Role">
    <input type="submit" value="Save">
</form>
</body>
</html>
