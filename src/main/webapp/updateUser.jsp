<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 24.04.2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>

Edit user?
<br>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="text" name="upName" placeholder="Edit name">
    <input type="text" name="upMail" placeholder="Edit e-mail">
    <input type="text" name="upAcc" placeholder="Edit account">
    <input type="submit" value="Edit">
</form>
</body>
</html>
