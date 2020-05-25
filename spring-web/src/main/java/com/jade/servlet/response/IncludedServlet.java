package com.jade.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IncludedServlet")
public class IncludedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("中华帝国<br/>");
        out.println("URI: " + request.getRequestURI() + " <br/>");
        out.println("QueryString " + request.getQueryString() + " <br/>");
        out.println("parameter p1 " + request.getParameter("p1") + " <br/>");


    }
}
