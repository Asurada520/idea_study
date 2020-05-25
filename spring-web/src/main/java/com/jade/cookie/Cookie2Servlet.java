package com.jade.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie2Servlet")
public class Cookie2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Cookie ckEmail = new Cookie("email", "test2@it315.org");
//        ckEmail.setPath("/");

        Cookie ckPhone = new Cookie("phone", "15696164096");
//        ckPhone.setPath("/");
        ckPhone.setMaxAge(0);

        Cookie ckTest = new Cookie("sign", "it315");

        response.addCookie(ckEmail);
        response.addCookie(ckPhone);
        response.addCookie(ckTest);

        String cookieHeader = request.getHeader("Cookie");

        if (cookieHeader != null && !"".equals(cookieHeader)) {

            out.println("请求头中的Cookie头字段信息如下：<br/>");
            out.println("Cookie:" + cookieHeader + "<br/>");

        } else {

            out.println("请求头中没有Cookie头字段信息<br/>");

        }


        Cookie[] cks = request.getCookies();

        for (int i = 0; cks != null && i < cks.length; i++) {

            Cookie cookie = cks[i];
            out.println(cookie.getName() + ":" + cookie.getValue() + "<br/>");

        }

    }
}
