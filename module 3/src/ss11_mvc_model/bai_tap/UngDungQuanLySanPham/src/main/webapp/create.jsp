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
    <title>Create Product Form</title>
</head>
<body>

<h1>Create new product</h1>

<p>
    <a href="products?">Back to product list</a>
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
            <td><label>ID: </label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>

        <tr>
            <td><label>Name: </label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>

        <tr>
            <td><label>Price: </label></td>
            <td><input type="text" name="price" id="price"></td>
        </tr>

        <tr>
            <td><label>Description: </label></td>
            <td><input type="text" name="description" id="description"></td>
        </tr>

        <tr>
            <td><label>Manufacturer: </label></td>
            <td><input type="text" name="manufacturer" id="manufacturer"></td>
        </tr>
        </tbody>

        <tfoot>
        <input type="submit" value="Create product">
        </tfoot>
    </table>
</form>
</body>
</html>
