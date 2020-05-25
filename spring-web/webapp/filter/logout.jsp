<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/12
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
    <%
        session.invalidate();
    %>
    <jsp:forward page="/filter/logon.jsp"/>
</body>
</html>
