<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>dealError</title>
</head>
<body>
    <%
        out.println("output of dealError!<br/>");
        out.println("<br/>");
        exception.printStackTrace(new PrintWriter(out));
    %>
</body>
</html>
