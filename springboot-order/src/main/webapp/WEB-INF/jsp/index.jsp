<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp document</title>
</head>
<body>

		<form action="${pageContext.request.contextPath}/xss/postIndex" method="post">
			查询条件:<input type="text" name="name"/><br/>
			<input type="submit" value="查询"/>
		</form>

</body>
</html>