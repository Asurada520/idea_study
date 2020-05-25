package com.jade.servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String china1 = "中国";
//        String china = URLEncoder.encode(china1, "GB2312");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("chineseParamServlet?p1=" + URLEncoder.encode(china1, "GB2312"));
        requestDispatcher.forward(request,response);
    }
}
