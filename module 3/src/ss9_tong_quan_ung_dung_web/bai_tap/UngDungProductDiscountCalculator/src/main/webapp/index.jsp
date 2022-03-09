<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/9/2022
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
<form method="post" action="/DiscountCalculatorServlet">
  <label>Product Description</label>
  <input type="text" name="product_description" placeholder="Mô tả của sản phầm"/></br></br>

  <label>List Price</label>
  <input type="text" name="list_price" placeholder="Giá niêm yết của sản phẩm"/></br></br>

  <label>Discount Percent</label>
  <input type="text" name="discount_percent" placeholder="Tỷ lệ chiết khấu phần trăm"/></br></br>

  <input type="submit" id="submit" value="Calculate Discount">
</form>
  </body>
</html>
