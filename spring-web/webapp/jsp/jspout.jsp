<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/30
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jspOut</title>
</head>
<body>
<%
    ServletOutputStream sos = response.getOutputStream();
    sos.println("www.jade.com");
%>
</body>
</html>
