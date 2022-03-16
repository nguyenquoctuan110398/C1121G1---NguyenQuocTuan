<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/15/2022
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h2>Edit user</h2>

<p>
    <a href="users?">Back to user list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td><label for="name">Name: </label></td>
                <td><input type="text" name="name" id="name" value="${userToEdit.name}"></td>
            </tr>

            <tr>
                <td><label for="email">Email: </label></td>
                <td><input type="text" name="email" id="email" value="${userToEdit.email}"></td>
            </tr>

            <tr>
                <td><label for="country">Country: </label></td>
                <td><input type="text" name="country" id="country" value="${userToEdit.country}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
