<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>pay</title>
</head>

<body>

    <form action="/pay" method="post">
        <span>选择支付金额：</span>
        <select name="money">
            <option value="10">普通会员</option>
            <option value="20">铂金会员</option>
            <option value="30">黄金会员</option>
        </select>
        <input type="submit" value="支付确认"/>
    </form>

</body>

</html>