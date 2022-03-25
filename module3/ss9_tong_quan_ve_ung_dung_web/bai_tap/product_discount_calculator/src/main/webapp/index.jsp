<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/03/2022
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/display-discount">
    <input type="text" name="productDescription" placeholder="Product Description"><br>
    <input type="text" name="listPrice" placeholder="List Price"><br>
    <input type="text" name="discountPercent" placeholder="Discount Percent"><br>
    <input type="submit" id="submit" value="Calculate Discount">
  </form>
  </body>
</html>
