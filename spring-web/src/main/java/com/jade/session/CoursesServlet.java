package com.jade.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Vector;

@WebServlet(name = "CoursesServlet")
public class CoursesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String sessionName = (String) session.getAttribute("name");
        /*
            如果用户没有登录，sessionName 为null,或者上次访问后的空闲时间超过了session的限制
            getSession() 方法返回的是一个新的 Session 对象， sessionName 也为NULL
        */
        if (sessionName == null) {
            /*
                因为 下面是 同一个Web应用程序内部跳转的，最好采用 forward() 方法 进行请求转发，
                这里仅仅为了复习sendRedirect() 方法
            */
            response.sendRedirect("../logon.html");
            return;
        }

        String courseSelect = request.getParameter("course");
        if (courseSelect != null) {
            Vector vCourses = (Vector) session.getAttribute("courses");
            if (vCourses == null) {
                vCourses = new Vector();
                vCourses.add(courseSelect);
                session.setAttribute("courses", vCourses);

            } else {
                if (vCourses.contains(courseSelect)) {
                    out.println(sessionName + ", 您以前选择过了, " + courseSelect + "<br/>");
                } else {
                    /*
                        vCourses 是 指向  Session 中的一个属性对象的引用，
                        对vCourses 的操作直接影响那个属性对象，不用再将vCourses 重新增加进Session中
                    */
                    vCourses.add(courseSelect);
                }
            }

        }

        out.println("<br/>");

        String[] courses = {"c", "c++", "vc++", "java", "jsp"};
        out.println(sessionName + ", 请选择你要选修的课程：<br/>");
        for (int i = 0; i < courses.length; i++) {
            // 对参数中的特殊字符应进URL编码

            out.println(courses[i] + "&nbsp;&nbsp;&nbsp;&nbsp;<a href='coursesServlet?course=" + URLEncoder.encode(courses[i],"utf-8") + "'>选修</a><br/>");
        }

        out.println("<br/>");

        Vector vCourses = (Vector) session.getAttribute("courses");
        out.println(sessionName + ", 您选择了如下的课程：<br/>");
        if (vCourses != null) {
            for (Enumeration enumeration = vCourses.elements(); enumeration.hasMoreElements(); ) {
                out.println((String) enumeration.nextElement() + "<br/>");
            }
        }

    }
}
