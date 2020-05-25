package com.jade.servlet.response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ForwardTestServlet")
public class ForwardTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");

//        PrintWriter out = response.getWriter();
//
//        response.setContentType("GBK");

//        out.println("before forward");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/order.png");
        rd.forward(request,response);

//        out.println("after forward");
    }
}
