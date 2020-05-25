<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
    <%--<%
        pageContext.forward("/test.html");
    %>--%>

<%!
    PageContext lastPageContext = null;
    int count = 0;
%>

<%
    if(count != 0){

        if(lastPageContext == pageContext){
            out.println("本次与上次的pageContext相同<br/>");
        }else {
            out.println("本次与上次的pageContext不同<br/>");
        }
        String x = (String)pageContext.getAttribute("x");

        if("abc".equals(x)){
            out.println("本次已经获得上次存储在 pageContext 中的属性<br/>");
        }else{
            out.println("本次未获得上次存储在 pageContext 中的属性<br/>");
        }
    }

    lastPageContext = pageContext;
    pageContext.setAttribute("x", new String("abc"));
    count++;
%>

</body>
</html>
