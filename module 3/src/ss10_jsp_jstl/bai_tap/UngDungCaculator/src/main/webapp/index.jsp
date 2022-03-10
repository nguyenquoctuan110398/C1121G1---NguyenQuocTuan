<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/10/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>

<form method="post" action="/CalculatorServlet">
    <h3>Calculator</h3>
    <table>
        <tr>
            <td><label>First operand: </label></td>
            <td><input type="text" name="first-operand"></td>
        </tr>
        <tr>
            <td><label>Operator: </label></td>
            <td><select name="operator">
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiplication</option>
                <option value="/">Division</option>
            </select></td>
        </tr>

        <tr>
            <td><label>Second operand: </label></td>
            <td><input type="text" name="second-operand"></td>
        </tr>
    </table>
    <br>
    
    <input type="submit" id="submit" value="Calculator" style="text-align: center">

</form>

</body>
</html>
