<%@ page import="com.jade.listener.MyBean" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/15
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sessionBinding</title>
</head>
<body>
    <h4>
        感知 Session 绑定的综合案例
    </h4>
    <%
        System.out.println("当前sessionID:" + session.getId());
        session.setAttribute("myBean",new MyBean());
//        session.removeAttribute("myBean");
    %>

</body>
</html>
