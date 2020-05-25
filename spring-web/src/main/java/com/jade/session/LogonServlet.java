package com.jade.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogonServlet")
public class LogonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        // 设置 session 超时时间间隔为 120 秒 ，以便测试超时的情况
        session.setMaxInactiveInterval(120);

        String name = (String) session.getAttribute("name");
        System.out.println("Name:" + name);
        // 如果是一个 已登录账户，则将请求转发给显示课程的 Servlet
        if (name != null) {
            request.getRequestDispatcher("coursesServlet").forward(request, response);
            return;
        }

        String nameParam = request.getParameter("name");

        nameParam = new String(nameParam.getBytes("iso-8859-1"),"utf-8");

        System.out.println("NameParam:" + nameParam);

        if (nameParam == null || "".equals(nameParam)) {
            out.println("请传递一个用户名！<br/>");
            request.getRequestDispatcher("../logon.html").include(request, response);
        } else {
            session.setAttribute("name", nameParam);
            request.getRequestDispatcher("coursesServlet").forward(request, response);
        }

        out.close();

    }
}
