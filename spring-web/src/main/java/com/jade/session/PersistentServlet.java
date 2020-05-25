package com.jade.session;

import com.jade.entity.Student1;
import com.jade.entity.Student2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersistentServlet")
public class PersistentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Student1 student1 = (Student1) session.getAttribute("student1");

        if (student1 == null) {
            student1 = new Student1();
            student1.setValue(35);
            session.setAttribute("student1", student1);
            out.println("将student1保存到了Session中！<br/>");
        } else {
            out.println("读取student1：" + student1.getValue() + "<br/>");
        }

        Student2 student2 = (Student2) session.getAttribute("student2");
        if (student2 == null) {
            student2 = new Student2();
            student2.setValue(33);
            session.setAttribute("student2", student2);
            out.println("将student2保存到了Session中！<br/>");
        } else {
            out.println("读取student2：" + student2.getValue() + "<br/>");
        }

    }
}
