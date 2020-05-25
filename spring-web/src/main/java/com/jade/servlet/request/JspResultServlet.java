package com.jade.servlet.request;

import com.jade.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JspResultServlet")
public class JspResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        User user = (User) request.getAttribute("user");

        if (user != null) {
            out.println("<h1>您注册的信息如下：</h1>");
            out.println("用户名:" + user.getName() + "<br/>");
            out.println("Email:" + user.getEmail() + "<br/>");
            System.out.println("用户名:" + user.getName());
            System.out.println("Email:" + user.getEmail());
        }

        out.close();

    }
}
