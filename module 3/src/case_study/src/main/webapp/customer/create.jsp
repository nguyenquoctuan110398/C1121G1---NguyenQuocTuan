<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/18/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Create Customer Form</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<h1>Create new customer</h1>--%>

<%--<p>--%>
<%--    <a href="customers?">Back to Customer list</a>--%>
<%--</p>--%>

<%--<p>--%>
<%--    <c:if test='${requestScope["message"]!=null}'>--%>
<%--        <span class="message">${message}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>

<%--<form method="post">--%>
<%--    <table class="table">--%>
<%--        <tbody>--%>
<%--                <tr>--%>
<%--                    <td><label for="customer_code">Customer code: </label></td>--%>
<%--                    <td><input type="text" name="customer_code" id="customer_code"></td>--%>
<%--                    <td style="color: red;">${error.get("code")}</td>--%>
<%--                </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_name">Name: </label></td>--%>
<%--            <td><input type="text" name="customer_name" id="customer_name"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_birthday">Birthday: </label></td>--%>
<%--            <td><input type="text" name="customer_birthday" id="customer_birthday"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_gender">Gender: </label></td>--%>
<%--&lt;%&ndash;            <td><input type="text" name="customer_gender" id="customer_gender"></td>&ndash;%&gt;--%>
<%--            <td>--%>
<%--                <select name="customer_gender" id="customer_gender">--%>
<%--                    <option value="0">Nữ</option>--%>
<%--                    <option value="1">Nam</option>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_id_card">Id card: </label></td>--%>
<%--            <td><input type="text" name="customer_id_card" id="customer_id_card"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_phone">Phone: </label></td>--%>
<%--            <td><input type="text" name="customer_phone" id="customer_phone"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_email">Email: </label></td>--%>
<%--            <td><input type="text" name="customer_email" id="customer_email"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_address">Address: </label></td>--%>
<%--            <td><input type="text" name="customer_address" id="customer_address"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td><label for="customer_type_id">Customer type id: </label></td>--%>
<%--            <td>--%>
<%--                <select name="customer_type_id" id="customer_type_id">--%>
<%--                    <c:forEach var="customerType" items="${customer_type}">--%>
<%--                        <option value="${customerType.id}">${customerType.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--&lt;%&ndash;            <td><input type="text" name="customer_type_id" id="customer_type_id"></td>&ndash;%&gt;--%>
<%--        </tr>--%>

<%--        </tbody>--%>

<%--        <tfoot>--%>
<%--        <input type="submit" value="Create product">--%>
<%--        </tfoot>--%>
<%--    </table>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Courgette|Pacifico:400,700">
    <title>Bootstrap Start Free Trail Sign up Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #999;
            background: #e2e2e2;
            font-family: 'Roboto', sans-serif;
        }

        .form-control {
            min-height: 41px;
            box-shadow: none;
            border-color: #e1e1e1;
        }

        .form-control:focus {
            border-color: #00cb82;
        }

        .form-control, .btn {
            border-radius: 3px;
        }

        .form-header {
            margin: -30px -30px 20px;
            padding: 30px 30px 10px;
            text-align: center;
            background: #00cb82;
            border-bottom: 1px solid #eee;
            color: #fff;
        }

        .form-header h2 {
            font-size: 34px;
            font-weight: bold;
            margin: 0 0 10px;
            font-family: 'Pacifico', sans-serif;
        }

        .form-header p {
            margin: 20px 0 15px;
            font-size: 17px;
            line-height: normal;
            font-family: 'Courgette', sans-serif;
        }

        .signup-form {
            width: 390px;
            margin: 0 auto;
            padding: 30px 0;
        }

        .signup-form form {
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #f0f0f0;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        .signup-form .form-group {
            margin-bottom: 20px;
        }

        .signup-form label {
            font-weight: normal;
            font-size: 14px;
        }

        .signup-form input[type="checkbox"] {
            position: relative;
            top: 1px;
        }

        .signup-form .btn {
            font-size: 16px;
            font-weight: bold;
            background: #00cb82;
            border: none;
            min-width: 200px;
        }

        .signup-form .btn:hover, .signup-form .btn:focus {
            background: #00b073 !important;
            outline: none;
        }

        .signup-form a {
            color: #00cb82;
        }

        .signup-form a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body style="background-image: url('https://2.bp.blogspot.com/-p4YSrDC71vg/V-0-syEg7pI/AAAAAAAAALY/ZEUehoQplUASGe8JmUrcCRcNYefNJUNAACEw/s1600/galaxy-wallpapers.png');">
<div class="signup-form" >
    <form method="post">
        <div class="form-header">
            <h2>Create Customer</h2>
            <c:if test='${requestScope["message"]!=null}'>
                <span class="message">${message}</span>
            </c:if>
            <p>
                <a href="customers?" style="color:white;">Back to Customer list</a>
            </p>
        </div>
        <div class="form-group">
            <label for="customer_code">Customer code: </label>
            <input type="text" class="form-control" name="customer_code" id="customer_code" required="required">
            <p style="color: red;">${error.get("code")}</p>
            <p style="color: red;">${error.get("checkCodeExist")}</p>
        </div>

        <div class="form-group">
            <label for="customer_name">Name: </label>
            <input type="text" class="form-control" name="customer_name" id="customer_name" required="required">
            <p style="color: red;">${error.get("name")}</p>
        </div>

        <div class="form-group">
            <label for="customer_birthday">Birthday: </label>
            <input type="date" name="customer_birthday" id="customer_birthday" class="form-control" required="required">
        </div>

        <div class="form-group">
            <label for="customer_gender">Gender: </label>
            <select name="customer_gender" id="customer_gender" class="form-control" required="required">
                <option value="0">Nữ</option>
                <option value="1">Nam</option>
            </select>
        </div>

        <div class="form-group">
            <label for="customer_id_card">Id card: </label>
            <input type="text" name="customer_id_card" id="customer_id_card" class="form-control" required="required">
            <p style="color: red;">${error.get("idCard")}</p>
        </div>

        <div class="form-group">
            <label for="customer_phone">Phone: </label>
            <input type="text" name="customer_phone" id="customer_phone" class="form-control" required="required">
            <p style="color: red;">${error.get("phone")}</p>
        </div>

        <div class="form-group">
            <label for="customer_email">Email: </label>
            <input type="text" name="customer_email" id="customer_email" class="form-control" required="required">
            <p style="color: red;">${error.get("email")}</p>
        </div>

        <div class="form-group">
            <label for="customer_address">Address: </label>
            <input type="text" name="customer_address" id="customer_address" class="form-control" required="required">
        </div>

        <div class="form-group">
            <label for="customer_type_id">Customer type id: </label>
            <select name="customer_type_id" id="customer_type_id" class="form-control" required="required">
                <c:forEach var="customerType" items="${customer_type}">
                    <option value="${customerType.id}">${customerType.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block btn-lg">Save</button>
        </div>
    </form>
</div>
</body>
</html>