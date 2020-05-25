<%@ page import="javax.servlet.jsp.tagext.BodyContent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pushBody</title>
</head>
<body>
<%
    JspWriter anotherOut = pageContext.getOut();

    if (anotherOut == out) {
        out.println("1.初始的pageContext.getOut()方法的返回值，就是隐式out对象<br/>");
    }

    BodyContent out1 = pageContext.pushBody();
    JspWriter out2 = pageContext.getOut();
    if (out1 == out2) {
        out.println("2.pageContext.pushBody()方法与后面调用的PageContext.getOut()方法的返回值相同<br/>");
    }

    if (out2 != out) {
        out.println("这个返回值不等于隐式out对象");
        out1.writeOut(((BodyContent) out2).getEnclosingWriter());
        out.println("将上面的内容以字符串返回后再输出一遍：" + out1.getString()+"<br/>");
    }

    JspWriter out3 = pageContext.popBody();
    JspWriter out4 = pageContext.getOut();
    if (out3 == out4) {
        out.println("3. pageContext.pop()方法与后面调用的pageContext.getOut()方法的返回值相同<br/>");
    }

    if (out4 == out) {
        out.println("这个返回值又等于隐式out对象了<br/>");
    }


%>
</body>
</html>
