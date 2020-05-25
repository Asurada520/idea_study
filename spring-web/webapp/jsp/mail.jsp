<%@ page import="java.util.Vector" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<%!
    Vector getMails(ServletContext application) throws IOException {
        InputStream ips = application.getResourceAsStream("/mails.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(ips, "UTF-8"));

        Vector vMails = new Vector();
        String mail = br.readLine();

//        mail = new String(((java.lang.String) mail).getBytes("iso-8859-1"),"utf-8");
        while (mail != null) {
            vMails.add(mail);
            System.out.println("mail:" + mail);
            mail = br.readLine();
        }
        br.close();
        return vMails;
    }
%>
<html>
<head>
    <title>E-mail</title>

    <script>

        function checkAll() {
            var mail = document.mailForm.mail;
            console.info("mail:" + mail.toString());

            if (mail == null) {
                return;
            }

            var count = mail.length;
            console.info(count);

            if (count == null) {
                mail.checked = document.mailForm.ifAll.checked;
                return;
            }

            for (var i = 0; i < count; i++) {
                mail[i].checked = document.mailForm.ifAll.checked;
                console.info("document.mailForm.ifAll.checked:" + document.mailForm.ifAll.checked);
            }

        }

    </script>

</head>
<body>

<form name="mailForm">
    <%
        Vector v = getMails(application);
        for (Enumeration e = v.elements(); e.hasMoreElements(); ) {
            String mail = (String) e.nextElement();
            out.println("<input type='checkbox' name = 'mail'/>" + mail + "<br/>");
        }
    %>
    <input type="checkbox" name="ifAll" onclick="checkAll()"/>全选<br/>
    <input type="submit"/><br/>

    <%for (int i = 1; i < 7; i++) {%>
    <H<%=i%>>www.jade.com</H<%=i%>>
    <%}%>

</form>

</body>
</html>
