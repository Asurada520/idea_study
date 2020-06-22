package com.jade.servlet.request;

import sun.misc.BASE64Decoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Enumeration;

@WebServlet(name = "AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {

    private int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

//        print headers
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("--- begin --- ");

        while (headerNames.hasMoreElements()) {
            String headName = headerNames.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println(headName + " : " + headValue);
        }

        System.out.println("--- end ----");

//        要求客户端发送身份证认证信息，并且只能是BASIC认证方式中
        String encodeAuth = request.getHeader("Authorization");
        System.out.println("EncodeAuth: " + encodeAuth);

        if (encodeAuth == null || !encodeAuth.toUpperCase().startsWith("BASIC")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("WWW-Authenticate", "BASIC realm=\"jade\""); // todo
            out.println("没有传递身份验证");
            return;
        }

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodeBytes = decoder.decodeBuffer(encodeAuth.substring(6));

        System.out.println("DecodesBytes: " + Arrays.toString(decodeBytes));

        String decodeInfo = new String(decodeBytes);

        System.out.println("DecodeInfo: " + decodeInfo);

        int idx = decodeInfo.indexOf(":");
        if (idx < 0) {
            out.println("信息格式不完整");
            return;
        }

        String user = decodeInfo.substring(0, idx);
        String password = decodeInfo.substring(idx + 1);

        if ("zxx".equals(user) && "123456".equals(password)) {
            out.println("这是您要看的信息 ... ");
        } else {
            count++;
            System.out.println("count=" + count);
            if (count > 3) {
                out.println("您无权访问此信息");
                return;
            }
            out.println("权限受限，烦请联系管理员 ... ");

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("WWW-Authenticate", "BASIC realm=\"jade\""); // todo
        }

//        out.close();

    }
}














