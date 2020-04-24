<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 24.04.2020
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>

Delete user: "${param.email}" ?
<br>

<form action="/delete" method="post">
    <input type="hidden" name="name" value="${param.name}">
    <input type="hidden" name="email" value="${param.email}">
    <input type="hidden" name="acc" value="${param.acc}">
    <input type="submit" value="Delete">
</form>
</body>
</html>
