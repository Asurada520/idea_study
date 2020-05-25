package com.jade.servlet.response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IncludingServlet")
public class IncludingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String china = "中华";
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/includedServlet?p1=" + china);
        out.println("before including<br/>");
        rd.include(request,response);
        out.println("after including<br/>");

    }
}
