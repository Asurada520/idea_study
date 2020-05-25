<%@ page import="com.jade.util.DbUtil" %>
<%@ page import="com.jade.entity.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logon</title>
</head>
<body>
<%if (session.getAttribute("logonUser") != null) {%>
<jsp:forward page="jspSuccess.jsp"/>
<%}%>
<jsp:useBean id="logonForm" class="com.jade.entity.LogonFormBean" scope="page"/>
<jsp:setProperty name="logonForm" property="*"/>

<%
    // 如果JSP页面的当前执行过程是对表单提交的响应
    if (request.getParameter("submit") != null) {
        if (logonForm.validate()) {
            DbUtil instance = DbUtil.getInstance();
            UserBean user = instance.getUser(logonForm.getName());

            if (user == null) {
                logonForm.setErrorMsg("name", "this user is not exist!");
            } else {
                if (user.validatePassword(logonForm.getPassword())) {
                    session.setAttribute("logonUser", user);
%>
<jsp:forward page="jspSuccess.jsp"/>
<%
                } else {
                    logonForm.setErrorMsg("password", "password is error!");
                }
            }

        }
    }
%>
</body>
</html>
