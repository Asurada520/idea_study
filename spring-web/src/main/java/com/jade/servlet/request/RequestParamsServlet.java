package com.jade.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "RequestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()){

            String paramName = (String) parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            byte[] bytes = paramValue.getBytes();

            String s = new String(bytes, "utf-8");

            out.println(paramName + ":" + request.getParameter(paramName)+"<br/>");
            System.out.println(paramName + ":" + request.getParameter(paramName));

            /* 如果 考虑  同一个请求头名称 可能出现多次情况， 那么应该使用下面的代码段 代替上面的一行代码*/
            /*String[] parameterValues = request.getParameterValues(paramName);
            *//* 良好的习惯，在使用对象和数组之前 先判断其是否为null*//*
            if(parameterNames != null){
                for (String paramValue : parameterValues) {
                    out.println(paramName + ":" + paramValue +"<br/>");
                }
            }*/

        }

    }
}
