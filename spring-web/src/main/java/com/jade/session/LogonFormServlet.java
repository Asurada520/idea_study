package com.jade.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogonFormServlet")
public class LogonFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        if(session == null){
            out.println("验证码处理问题！");
            return;
        }

        String check_code = (String)session.getAttribute("check_code");
        if(check_code == null ||"".equals(check_code)){
            out.println("验证码处理问题！");
            return;
        }

        String checkCode = request.getParameter("check_code");
        if(!check_code.equals(checkCode)){
            /*
                验证码未通过，不从Session中清除原来的验证码，
                以便用户可以回退登录页面继续使用原来的验证码进行登录
             */
            out.println("验证码无效！");
            return;
        }

        /*
            验证码检查通过后，从Session中清除原来的验证码，
            以防用户回退登录页面继续使用原来的验证码进行登录
        */
        session.removeAttribute("check_code");
        out.println("验证码通过，服务器正在校验用户名和密码，请等待登录成功 ... ");

    }
}
