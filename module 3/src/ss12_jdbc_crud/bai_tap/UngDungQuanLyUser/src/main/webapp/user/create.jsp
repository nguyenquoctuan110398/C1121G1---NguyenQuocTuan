<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/14/2022
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User Form</title>
</head>
<body>

<h1>Create new user</h1>

<p>
    <a href="users?">Back to user list</a>
</p>

<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>

<form method="post">
    <table class="table">
        <tbody>
        <tr>
            <td><label for="id">ID: </label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>

        <tr>
            <td><label for="name">Name: </label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>

        <tr>
            <td><label for="email">Email: </label></td>
            <td><input type="text" name="email" id="email"></td>
        </tr>

        <tr>
            <td><label for="country">Country</label></td>
            <td><input type="text" name="country" id="country"></td>
        </tr>

        </tbody>

        <tfoot>
        <input type="submit" value="Create product">
        </tfoot>
    </table>
</form>
</body>
</html>
