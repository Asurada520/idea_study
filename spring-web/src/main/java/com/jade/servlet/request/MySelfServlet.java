package com.jade.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MySelfServlet")
public class MySelfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name = new String(request.getParameter("p1").getBytes("ISO-8859-1"), "UTF-8");
        //定义输出!
        PrintWriter out = response.getWriter();
        out.println(name);
        out.println("你好,我是doGet!");
    }
}
