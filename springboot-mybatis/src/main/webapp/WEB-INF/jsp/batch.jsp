<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>数据文件导入</title>
</head>
<body>
司机信息
<form action="/batch/wxDriverInfo" method="post" enctype="multipart/form-data">
    <input type="file" name="filename"/>
    <input type="submit" value="导入"/>
</form>
<a href="/go/download?fileType=1">模板下载</a>
<hr/>
高德订单
<form action="/batch/gaoDeBillOrder" method="post" enctype="multipart/form-data">
    <input type="file" name="filename"/>
    <input type="submit" value="导入"/>
</form>
<a href="/go/download?fileType=2">模板下载</a>
<hr/>
<form action="export" method="post">
    <input type="submit" value="导出">
</form>
<%--导入模版下载
<form action="/go/download" method="post">
    <select>
    </select>
    <input type="submit" value="导出">
</form>--%>

</body>
</html>