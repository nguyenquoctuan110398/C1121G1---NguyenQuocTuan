<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/9/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Directory</title>
  </head>
  <body>

  <h2>Vietnamese Dictionary</h2>

  <form action="/TranslationServlet" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search">
  </form>

  </body>
</html>
