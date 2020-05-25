<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html; charset=utf-8" %>
<head>
    <meta charset="UTF-8">
    <title>mailList</title>

    <script>

        function checkAll() {
            var mail = document.mailForm.mail;
            console.info("mail:" + mail.toString());

            if(mail == null){
                return;
            }

            var count = mail.length;
            console.info(count);

            if(count == null){
                mail.checked = document.mailForm.ifAll.checked;
                return;
            }

            for (var i = 0; i < count; i++) {
                mail[i].checked = document.mailForm.ifAll.checked;
                console.info("document.mailForm.ifAll.checked:"+document.mailForm.ifAll.checked);
            }

        }

    </script>

</head>
<body>

<form name="mailForm">
    <input type="checkbox" name="mail" value="1"/>邮件1<br/>
    <input type="checkbox" name="mail" value="2"/>邮件2<br/>
    <input type="checkbox" name="mail" value="3"/>邮件3<br/>
    <input type="checkbox" name="ifAll" onclick="checkAll()"/>全选<br/>
    <input type="submit"/><br/>
</form>

</body>
</html>