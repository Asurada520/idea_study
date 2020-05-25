<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>attributeListener</title>
</head>
<body>
    <h4>测试对象属性信息监听器的页面</h4>

<%
    getServletConfig().getServletContext().setAttribute("username","it315");
    getServletConfig().getServletContext().setAttribute("username","zxx");
    getServletConfig().getServletContext().removeAttribute("username");

    session.setAttribute("username","tangqq");
    session.setAttribute("username","huangjy");
    session.removeAttribute("username");

    request.setAttribute("username","wangxin");
    request.setAttribute("username","songyc");
    request.removeAttribute("username");

%>
</body>
</html>
