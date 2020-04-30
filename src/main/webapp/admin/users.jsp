<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 24.04.2020
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
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
List of users
<br>
</body>
<body>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>e-mail</th>
        <th>Password</th>
        <th>Acc</th>
        <th>Role</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getMail()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getAcc()}</td>
            <td>${user.getRole()}</td>
            <td>
                <form action="/admin/updateUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="/admin/deleteUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="/admin/addUser.jsp">
    <input type="submit" value="Add new user">
</form>
<br>
<form action="startPage.jsp">
    <input type="submit" value="Log out">
</form>
<form action="/user">
    <input type="submit" value="Show auth user">
</form>
</body>
</html>
