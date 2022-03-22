<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/20/2022
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<h2>Edit customer</h2>

<p>
    <a href="customers?">Back to customer list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td><label for="customer_name">Name: </label></td>
                <td><input type="text" name="customer_name" id="customer_name" value="${customerToEdit.name}"></td>
            </tr>

            <tr>
                <td><label for="customer_birthday">Birthday: </label></td>
                <td><input type="text" name="customer_birthday" id="customer_birthday" value="${customerToEdit.birthday}"></td>
            </tr>

            <tr>
                <td><label for="customer_gender">Gender</label></td>
                <td>
                    <%--                    <input type="text" name="customer_gender" id="customer_gender" value="${customerToEdit.gender}">--%>
                    <select name="customer_gender" id="customer_gender">
                        <c:if test="${customerToEdit.gender == 0}">
                            <option value="0" selected>Nữ</option>
                            <option value="1">Nam</option>
                        </c:if>
                        <c:if test="${customerToEdit.gender == 1}">
                            <option value="0">Nữ</option>
                            <option value="1" selected>Nam</option>
                        </c:if>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label for="customer_id_card">Id card: </label></td>
                <td><input type="text" name="customer_id_card" id="customer_id_card" value="${customerToEdit.idCard}">
                </td>
            </tr>

            <tr>
                <td><label for="customer_phone">Phone: </label></td>
                <td><input type="text" name="customer_phone" id="customer_phone" value="${customerToEdit.phone}"></td>
            </tr>

            <tr>
                <td><label for="customer_email">Email: </label></td>
                <td><input type="text" name="customer_email" id="customer_email" value="${customerToEdit.email}"></td>
            </tr>

            <tr>
                <td><label for="customer_address">Address: </label></td>
                <td><input type="text" name="customer_address" id="customer_address" value="${customerToEdit.address}"></td>
            </tr>

            <tr>
                <td><label for="customer_type_id">Customer type id: </label></td>
<%--                <td><input type="text" name="customer_type_id" id="customer_type_id" value="${customerToEdit.customerTypeId}">--%>
                    <td><select name="customer_type_id" id="customer_type_id">

                        <c:forEach var="customerType" items="${customerTypes}">
                            <c:choose>
                                <c:when test="${customerType.id == customerToEdit.customerTypeId}">
                                    <option value="${customerType.id}" selected>${customerType.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${customerType.id}">${customerType.name}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </td>
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
