<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/14/2022
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>

<p>
    <a href="products?">Back to product list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${product.name}"></td>
            </tr>

            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${product.price}"></td>
            </tr>

            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description" value="${product.description}"></td>
            </tr>

            <tr>
                <td>Manufacturer</td>
                <td><input type="text" name="manufacturer" id="manufacturer" value="${product.manufacturer}"></td>
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
