<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testError</title>
</head>
<body>
    <%--<%@ page errorPage="dealError.jsp" %>--%>
    <%
        out.println("before exception!");
        int i = 1/0;
        out.println("after exception!");
    %>
</body>
</html>
