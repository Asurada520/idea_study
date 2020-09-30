<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/indentUpdate/addUpdate" method="post">
            <input type="hidden" name="token" value="${token}"/>
    订货单号:<input type="text" name="indent_code"/><br/>
    订货单描述：<input type="text" name="indent_desc"/><br/>
    <input type="submit" value="确定"/>
</form>

</body>
</html>