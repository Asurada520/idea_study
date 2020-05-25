package com.jade.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "DelArticleServlet")
public class DelArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String[] article_ids = request.getParameterValues("article_id");

        System.out.println("article_ids: " + Arrays.toString(article_ids));

        if (article_ids != null && article_ids.length != 0) {

            StringBuffer params = new StringBuffer("'"+article_ids[0]+"'");

            for (int i = 1; i < article_ids.length; i++) {
                params.append(", '").append(article_ids[i]+"'");
            }

            String sql = "";
            String operator = request.getParameter("del");
            if ("彻底删除".equals(operator)) {
                sql = "delete from lyb_Articles where ArticleId in(" + params + ")";
            } else if ("删除到垃圾桶".equals(operator)) {
                sql = "update lyb_Articles set is_del=1 where ArticleId in(" + params + ")";
            }

            out.println("向数据库系统发送如下sql命令:" + sql + "<br/>");

        } else {
            out.println("没有选择需要删除的帖子【post】！");
        }

        out.close();


    }


}
