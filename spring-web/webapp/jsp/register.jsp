<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/29
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>

    <%--<% String user = request.getParameter("user");%>--%>

    <form method="post">
        user:<input type="text" name="user" value="${param.user}"/><br/>
        <input type="submit" value="register"/><br/>
    </form>
</body>
</html>
