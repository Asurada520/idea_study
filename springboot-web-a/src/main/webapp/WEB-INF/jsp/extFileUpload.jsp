<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Program A</title>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>

</head>
<body>

<div class="information">

    <div class="information-ico">文件上传</div>

    <div class="information-img">
        <form action="/extFileUpload/upload" method="post"  id="form" name="form" enctype="multipart/form-data">

            <input type="file" name="file"/>
            <input type="submit" value="submit"/>
        </form>
    </div>

</div>

</body>
</html>