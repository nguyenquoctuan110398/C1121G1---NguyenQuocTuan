<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/03/2022
  Time: 1:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Search By Country</h2>
<p>
    <a href="/users">Back To Main</a>
</p>
<table align="center" border="1">
    <caption>Search Result :</caption>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
