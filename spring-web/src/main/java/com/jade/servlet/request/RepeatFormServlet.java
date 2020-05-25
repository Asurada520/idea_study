package com.jade.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RepeatFormServlet")
public class RepeatFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String note = request.getParameter("note");
            System.out.println("Note: " + note);
            Thread.sleep(6000);
            out.println("谢谢，系统处理了您提交的信息");
        } catch (InterruptedException e) {
            out.println("已经处理了您提交的信息");
            System.out.println("已经处理了您提交的信息");
        }
    }
}
