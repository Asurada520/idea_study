<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/14
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>onLineCount</title>
</head>
<body>
<h4>当前在线人数为：</h4>
<%=application.getAttribute("count")%><br/>
<a href="/jsp/logout.jsp">退出登录</a>
</body>
</html>
