<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/28
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>simple</title>
</head>
<body>

<%--基本 jsp 程序--%>
<%--
<%
    String currentTime = new Date().toString();
    out.println("current time is <i><u>" +currentTime +"</u></i>");
%>--%>
<%-- html 方式 编辑jsp 文件--%>
HTML, Current time is <i><u>
    <%
        String currentTime = new Date().toString();
        out.print(currentTime);
    %>
</u></i>
<br/>
<%-- jsp表达式  --%>
JSP expression1, Current time is <i><u>
    <%=new Date().toString()%>
</u></i>

<br/>
<%-- jsp表达式  --%>
JSP expression2, Current time is <i><u>
    <%=currentTime%>
</u></i><br/>

<%
    String strTest = null;
//    out.println("println : " + strTest);
    out.write("write : " + strTest);
%>


</body>
</html>
