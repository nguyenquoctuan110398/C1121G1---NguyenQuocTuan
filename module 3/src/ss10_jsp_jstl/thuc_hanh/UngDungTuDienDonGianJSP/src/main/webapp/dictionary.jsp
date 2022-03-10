<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/10/2022
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>

<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển sách");
    dic.put("computer", "Máy tính");
    dic.put("cat", "Con mèo");

    String search = request.getParameter("search");

    String result = dic.get(search);

    if (result != null) {
        out.println("Word: " + search + "<br>");
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }
%>

</body>
</html>
