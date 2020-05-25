package com.jade.servlet.request;

import com.jade.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "ActionServlet")
public class ActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String characterEncoding = request.getCharacterEncoding();
        System.out.println("ActionCharacterEncoding: " + characterEncoding);

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setEmail(email);

//        String nameDecode = URLDecoder.decode(name, "utf-8");
//        String s = new String(nameDecode.getBytes(), "utf-8");
        System.out.println("name:" + name + ", email:" + email);

        request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("jspResultServlet");

        rd.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
