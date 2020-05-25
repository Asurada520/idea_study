package com.jade.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(name = "ReadBodyServlet")
public class ReadBodyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream sis = request.getInputStream();
        String filePath = getServletContext().getRealPath("/body.txt");
        System.out.println("Path:" + filePath);

        FileOutputStream fos = new FileOutputStream(filePath);

        byte[] buf = new byte[1024];

        int length = sis.read(buf,0,1024);
        while (length != -1){
            fos.write(buf,0,1024);
            length = sis.read(buf,0,1024);
        }
        fos.close();
        sis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
