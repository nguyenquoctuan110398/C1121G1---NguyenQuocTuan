<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/10/2022
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hiển thị danh sách khách hàng</title>
    <style>
        tr, td, th {
            border-right: 1px solid black;
            border-bottom: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<table style="border-collapse: collapse; border: 2px solid black">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>

    <c:forEach var="person" items="${list}">
        <tr>
            <td class="p-4">${person.name}</td>
            <td class="p-4">${person.birthday}</td>
            <td class="p-4">${person.address}</td>
            <td class="p-4"><img style="width: 100px" src="${person.picture}" alt="pic"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
