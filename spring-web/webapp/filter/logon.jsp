<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- filter 功能测试 --%>

<html>
<head>
    <title>logon</title>
</head>
<body>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    System.out.println("BasePath:" + basePath);
%>
<base href='<%=basePath+"logon.jsp"%>'/>

<%
    if (session.getAttribute("logonUser") != null) {
%>
您已经登录了,请先<a href="/filter/logout.jsp">注销</a>后再重新登录！<br/>
<%
        return;
    }
%>

<%
    if (request.getParameter("submit") != null) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ("zxx".equals(userName) && "123".equals(password)) {
            session.setAttribute("logonUser", userName);
            String viewPage = (String) session.getAttribute("viewPage");
            if (viewPage == null) {
                viewPage = "/articles.html";
            }
%>
<jsp:forward page="<%=viewPage%>"/>
<%
} else {%>
用户名或者密码不正确！<br/>
<%

        }
    }
%>

请先登录：
<form action="" method="post">
    姓名：<input type="text" name="userName"/><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" name="submit" value="登录"/><br/>
</form>

</body>
</html>
