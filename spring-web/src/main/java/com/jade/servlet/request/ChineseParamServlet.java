package com.jade.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;

@WebServlet(name = "ChineseParamServlet")
public class ChineseParamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GB2312");
//        response.setCharacterEncoding("GB2312");
        PrintWriter out = response.getWriter();

//        request.setCharacterEncoding("GB2312");

        String p1 = request.getParameter("p1");

        if (p1 == null || "".equals(p1)) {
            out.println("请输入一个正确的参数");
            return;
        }

        out.println("[第一种中文乱码解决办法]，刚输入的参数为, p1=" + p1 +"<br/>");
        out.println("[第一种中文乱码解决办法]，刚输入的参数为, p11=" + URLDecoder.decode(p1, "GB2312") +"<br/>");

//        也可以使用下面的语句解决本程序的中文乱码问题
        String gb2312 = new String(p1.getBytes("iso8859-1"), "GB2312");
        out.println("[第二种中文乱码解决办法]，刚输入的参数为, p1="+ gb2312 + "<br/>");

        System.out.println("参数的编码集是，charset=" + request.getCharacterEncoding());

        int length = p1.length();
        System.out.println("参数值为, p1=" + p1);
        System.out.println("参数中字符个数, length=" + length);
        System.out.println("参数值修正后，P1=" + gb2312);

        System.out.println("参数中的每个字符的Unicode码值为, unicode:");

        for (int i = 0; i < length; i++) {
            int ch = p1.charAt(i);
            System.out.print("[" + Integer.toHexString(ch) + "]");
        }

        System.out.println();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
