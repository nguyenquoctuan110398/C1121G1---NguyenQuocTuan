<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/22/2022
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new service</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>

<h1>Create new service</h1>

<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<p>
    <a href="/services">Back to service list</a>
</p>

<form method="post">
    <fieldset>
        <legend>Service information</legend>
        <table>
            <tr>
                <td><label for="id">Id: </label></td>
                <td><input type="text" name="id" id="id"></td>
            </tr>

            <tr>
                <td><label for="name">Name: </label></td>
                <td><input type="text" name="name" id="name"></td>
            </tr>

            <tr>
                <td><label for="area">Area: </label></td>
                <td><input type="text" name="area" id="area"></td>
            </tr>

            <tr>
                <td><label for="cost">Cost: </label></td>
                <td><input type="text" name="cost" id="cost"></td>
            </tr>

            <tr>
                <td><label for="maxPeople">Max People: </label></td>
                <td><input type="text" name="maxPeople" id="maxPeople"></td>
            </tr>

            <tr>

                <td><label for="rentTypeId">Rent Type Id: </label></td>
                <td>
                    <select name="rentTypeId" id="rentTypeId">
                        <option value="1">Year</option>
                        <option value="2">Month</option>
                        <option value="3">Day</option>
                        <option value="4">Hour</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label>Service Type Id: </label></td>
                <td>
                    <c:forEach var="serviceType" items="${serviceTypes}">
                        <c:if test="${serviceType.serviceTypeId == idType}">
                            <input type="text" name="serviceTypeId" id="serviceTypeId" value="${serviceType.serviceTypeId}" hidden>${serviceType.serviceTypeName}
                        </c:if>
                    </c:forEach>
                </td>
            </tr>

            <c:if test="${idType != 3}">
                <tr>
                    <td><label for="standardRoom">Standard Room: </label></td>
                    <td>
                        <input type="text" name="standardRoom" id="standardRoom">
                    </td>
                </tr>
            </c:if>

            <c:if test="${idType != 3}">
                <tr>
                    <td><label for="descriptionOtherConvenience">Description Other Convenience: </label></td>
                    <td>
                        <input type="text" name="descriptionOtherConvenience" id="descriptionOtherConvenience">
                    </td>
                </tr>
            </c:if>

            <c:if test="${idType == 1}">
                <tr>
                    <td><label for="poolArea">Pool Area</label></td>
                    <td>
                        <input type="text" name="poolArea" id="poolArea">
                    </td>
                </tr>
            </c:if>

            <c:if test="${idType != 3}">
            <tr>
                <td><label for="numberOfFloors">Number Of Floors</label></td>
                <td>
                        <input type="text" name="numberOfFloors" id="numberOfFloors">
                </td>
            </tr>
            </c:if>

            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
