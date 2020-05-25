<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>debug</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        if(name.equals("zxx")){
            out.println("OK!");
        }
    %>
</body>
</html>
