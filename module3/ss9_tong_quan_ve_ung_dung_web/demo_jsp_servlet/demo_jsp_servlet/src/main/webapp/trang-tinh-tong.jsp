<%@ page import="java.io.FileOutputStream" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/18/2022
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đây là trang jsp</h1>
   <%
       // code java được việt tai đậy
       float n1 = Float.parseFloat(request.getParameter("num1"));
       float n2= Float.parseFloat(request.getParameter("num2"));
       float sum = n1+n2;
   %>
  <h1> Tổng của 2 số là :  <%=sum%></h1>
</body>
</html>
