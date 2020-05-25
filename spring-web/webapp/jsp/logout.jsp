<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/14
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My JSP 'MyJsp.jsp' starting page</title>
</head>
<body>
    <%
        session.invalidate(); // 使 session 对象失效
    %>
    <h4>您已经退出本系统</h4>
</body>
</html>
