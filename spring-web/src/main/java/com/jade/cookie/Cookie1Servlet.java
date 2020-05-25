package com.jade.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie1Servlet")
public class Cookie1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");

        if(name == null || nickname == null){
            out.println("请传递参数 name 和 nickname， 然后继续实验");
            return;
        }

        /*
             下面的代码 最好修改为如下代码，为了增强代码的可阅读性
             if(...){
                ...
                return;
             }

             因为笔者在后来校对书稿的过程中，发现，读到下面的 if 从句，脑海里很自然地出现了“if 从句执行完以后，程序继续干什么？”的疑问；
             如果在if从句中增加了return 语句后，显然就不会产生这样疑问了；

        */

        if("".equals(name.trim()) || "".equals(nickname.trim())){

            out.println("参数 name 和 nickname 不能为空字符串，谢谢");
            return;

        }else {

            Cookie ckName = new Cookie("name", name);

            Cookie ckNickname = new Cookie("nickname", nickname);
            ckNickname.setMaxAge(365*24*3600);

            Cookie ckEmail = new Cookie("email", "test1@it315.org");
            Cookie ckPhone = new Cookie("phone", "15251707110");

            /*设定*/
            response.addCookie(ckName);
            response.addCookie(ckNickname);
            response.addCookie(ckEmail);
            response.addCookie(ckPhone);

        }

        /*
            应该将下面的代码设计成一个专门用于查询某个名称的cookie的方法
            然后用这个方法来查询名称为nickname的cookie的值
        */

        String lastNickname = null;
        Cookie[] chs = request.getCookies();
        for (int i = 0; chs != null && i < chs.length; i++) {

            Cookie cookie = chs[i];

            if("nickname".equals(cookie.getName())){
                lastNickname = cookie.getValue();
                break;
            }

        }


        if(lastNickname != null && !"".equals(lastNickname)){
            out.println("欢迎您，<b><i>"+lastNickname+"<i/><b/> ！<br/>");
        }else{
            out.println("欢迎您，新客人！<br/>");
        }

        String cookieHeader = request.getHeader("Cookie");

        if(cookieHeader != null && !"".equals(cookieHeader)){

            out.println("请求头中的Cookie头信息如下：<br/>");
            out.println("Cookie: " + cookieHeader +"<br/>");

        }else{

            out.println("请求头中没有Cookie头字段信息<br/>");

        }





    }
}
