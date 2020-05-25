package com.jade.session;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AccessTimeServlet")
public class AccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 获取记录用户上次访问站点时间的 Cookie
        Cookie[] cks = request.getCookies();
        String lastAccessTime = getCookie(cks, "access_time");

        if (lastAccessTime == null) {
            out.println("您没有上次的访问记录<br/>");
        } else {
            BASE64Decoder decoder = new BASE64Decoder();
            String decoderAccessTime = new String(decoder.decodeBuffer(lastAccessTime), "utf-8");
            out.println("您上次的访问时间为：" + decoderAccessTime + "<br/>");
        }

        // 将用户开始本次访问的时间存储到客户端 Cookie 中
        HttpSession session = request.getSession();
        if (session.isNew()) {

            long creationTime = session.getCreationTime();
            Date dateCreateTime = new Date(creationTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            String formatCreateTime = sdf.format(dateCreateTime);

            BASE64Encoder encoder = new BASE64Encoder();
            String base64CreateTime = encoder.encode(formatCreateTime.getBytes("utf-8"));
            Cookie ckAccessTime = new Cookie("access_time", base64CreateTime);

            ckAccessTime.setMaxAge(365 * 24 * 60 * 60);
            out.println("本次访问时间为：" + formatCreateTime + "<br/>");
            response.addCookie(ckAccessTime);

        }


    }

    private String getCookie(Cookie[] cks, String access_time) {
        String cookieValue = null;

        for (int i = 0; cks != null && i < cks.length; i++) {
            String temp = cks[i].getName();

            if (access_time.equals(temp)) {
                cookieValue = cks[i].getValue();
                break;
            }
        }

        return cookieValue;
    }
}
