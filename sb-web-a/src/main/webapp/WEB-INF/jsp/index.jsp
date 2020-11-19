<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Program A</title>

    <script type="text/javascript" src="http://a.jade.com:8080/js/jquery-1.11.1.min.js"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>--%>

    <script type="text/javascript">

        $(document).ready(function () {
            $.ajax({

                type : "GET",
                async : false,
                //url : "http://b.jade.com:8081/bInfo", // ?jsonpCallback=随机数
                url : "http://www.jade.com/b/bInfo",
                dataType : "json",
                // dataType:"jsonp",
                // jsonp:"jsonpCallback", // 服务端用于接收callback调用的function名的参数
                success : function(data) {
                    alert(data["retMsg"]);
                },
                error : function() {
                    alert('fail');
                }

            });
        });

    </script>

</head>

    <body>
        这是项目A,正在调用B项目
    </body>

</html>
