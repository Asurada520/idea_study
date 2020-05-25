package com.jade.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    防止表单重复提交 后端程序实现
 */

@WebServlet(name = "FormDealServlet")
public class FormDealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        TokenProcessor tokenProcessor = TokenProcessor.getInstance();

        if (!tokenProcessor.isTokenValid(request)) {
            out.println("这是重复或非法提交！");
            return;
        }

        String p1 = request.getParameter("p1");
        if (p1 == null || "".equals(p1.trim())) {
            out.println("请输入内容！");
            return;
        } else {
            out.println("提交内容已被处理！");
            tokenProcessor.resetToken(request);
        }

        System.out.println("p1:" + new String(p1.getBytes("iso-8859-1"),"utf-8"));

    }
}
