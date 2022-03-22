<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/18/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer Form</title>
</head>
<body>

<h1>Create new customer</h1>

<p>
    <a href="customers?">Back to Customer list</a>
</p>

<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>

<form method="post">
    <table class="table">
        <tbody>
        <%--        <tr>--%>
        <%--            <td><label for="id">ID: </label></td>--%>
        <%--            <td><input type="text" name="id" id="id"></td>--%>
        <%--        </tr>--%>

        <tr>
            <td><label for="customer_name">Name: </label></td>
            <td><input type="text" name="customer_name" id="customer_name"></td>
        </tr>

        <tr>
            <td><label for="customer_birthday">Birthday: </label></td>
            <td><input type="text" name="customer_birthday" id="customer_birthday"></td>
        </tr>

        <tr>
            <td><label for="customer_gender">Gender: </label></td>
<%--            <td><input type="text" name="customer_gender" id="customer_gender"></td>--%>
            <td>
                <select name="customer_gender" id="customer_gender">
                    <option value="0">Nữ</option>
                    <option value="1">Nam</option>
                </select>
            </td>
        </tr>

        <tr>
            <td><label for="customer_id_card">Id card: </label></td>
            <td><input type="text" name="customer_id_card" id="customer_id_card"></td>
        </tr>

        <tr>
            <td><label for="customer_phone">Phone: </label></td>
            <td><input type="text" name="customer_phone" id="customer_phone"></td>
        </tr>

        <tr>
            <td><label for="customer_email">Email: </label></td>
            <td><input type="text" name="customer_email" id="customer_email"></td>
        </tr>

        <tr>
            <td><label for="customer_address">Address: </label></td>
            <td><input type="text" name="customer_address" id="customer_address"></td>
        </tr>

        <tr>
            <td><label for="customer_type_id">Customer type id: </label></td>
            <td>
                <select name="customer_type_id" id="customer_type_id">
                    <c:forEach var="customerType" items="${customer_type}">
                        <option value="${customerType.id}">${customerType.name}</option>
                    </c:forEach>
                </select>
            </td>
<%--            <td><input type="text" name="customer_type_id" id="customer_type_id"></td>--%>
        </tr>

        </tbody>

        <tfoot>
        <input type="submit" value="Create product">
        </tfoot>
    </table>
</form>
</body>
</html>

