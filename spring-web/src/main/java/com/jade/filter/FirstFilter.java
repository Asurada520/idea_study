package com.jade.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebFilter(filterName = "FirstFilter")
public class FirstFilter implements Filter {

    private FilterConfig filterConfig = null;

    String paramValue = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        paramValue = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        /*
            下面代码在命令行窗口中打印出所有的请求头信息，以便确认Filter是否起作用和帮助分析问题
        */
        System.out.println("begin headers ... ");

        Enumeration<String> headerNames = ((HttpServletRequest) request).getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+":"+((HttpServletRequest) request).getHeader(headerName));
        }

        System.out.println("end headers ... ");

        // 调用servlet之前写入响应内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("您的IP地址是：" + request.getRemoteAddr()+"<br/>");

        chain.doFilter(request, response);

        // 在目标servlet返回后写入响应内容
        out.println("<br/> 名称encoding的初始化参数是：" + paramValue);
        out.println("<br/> 当前web应用程序的真是路径是：" + filterConfig.getServletContext().getRealPath("/"));

    }

    public void destroy() {
        filterConfig = null;
    }

}
