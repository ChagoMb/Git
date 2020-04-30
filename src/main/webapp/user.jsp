<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 28.04.2020
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <style>
        TABLE {
            width: 600px;
            border-collapse: collapse;
        }
        TD, TH {
            padding: 1px;
            border: 1px solid lightgray;

        }
        TH {
            background: #696969;
        }
    </style>
</head>
<body>
Hello, ${name}!
<br><br>
<table>
    <tr>
        <th>Name</th>
        <th>e-mail</th>
        <th>Acc</th>
        <th>Role</th>
    </tr>
    <tr>
        <th><c:out value="${name}"/></th>
        <th><c:out value="${email}"/></th>
        <th><c:out value="${acc}"/></th>
        <th><c:out value="${role}"/></th>
    </tr>
</table>
<br><br>
<form action="startPage.jsp">
    <input type="submit" value="Log out">
</form>
</body>
</html>