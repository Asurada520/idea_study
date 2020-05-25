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

@WebServlet(name = "FormGenerateServlet")
public class FormGenerateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        TokenProcessor.getInstance().savedToken(request);

        String token = (String) request.getSession().getAttribute(TokenProcessor.FORM_TOKEN_KEY);
        out.println("<form action='formDealServlet' method='post'>" +
                "<input type='hidden' name='" + TokenProcessor.FORM_TOKEN_KEY + "' value='" + token + "'/><br/>" +
                "字段1：<input type='text' name='p1'/><br/>" +
                "<input type='submit' value='提交'/><br/>" +
                "</form>");

        out.close();
    }
}
