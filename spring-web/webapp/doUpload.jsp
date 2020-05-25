<%@ page import="com.jade.http.MultipartRequest" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/13
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doUpload</title>
</head>
<body>

用户：<%=request.getParameter("author")%><br/>
来自：<%=request.getParameter("company")%><br/>

上传了如下文件：
<ul>
    <%
        if (!(request instanceof MultipartRequest)) {
            return;
        }
        // 设置保存上传文件的路径
        String uploadDir = request.getServletContext().getRealPath("/upload");
        if (uploadDir == null) {
            out.println("不可以访问存储路径");
            return;
        }
        File fuUploadDir = new File(uploadDir);
        if (!fuUploadDir.exists()) {
            boolean mkdir = fuUploadDir.mkdir();
            if (!mkdir) {
                out.println("创建上传文件路径失败");
                return;
            }
        }
        MultipartRequest mReq = (MultipartRequest) request;
        Enumeration fileItemNames = mReq.getFileItemNames();

        while (fileItemNames.hasMoreElements()) {
            String name = (String) fileItemNames.nextElement();
            FileItem fileItem = mReq.getFileItem(name);

            String pathSrc = fileItem.getName();
            int start = pathSrc.lastIndexOf("//");
            String fileName = pathSrc.substring(start + 1);
            File pathDest = new File(uploadDir, fileName);
            fileItem.write(pathDest);

            out.println("<li>" + fileName + "</li>");


        }

    %>
</ul>
</body>
</html>
