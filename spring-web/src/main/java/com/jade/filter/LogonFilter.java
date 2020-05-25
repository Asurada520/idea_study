package com.jade.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器 处理 html 权限
 */
@WebFilter(filterName = "LogonFilter")
public class LogonFilter implements Filter {

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("logonUser") == null) {
            String requestURI = req.getRequestURI();
            String contextPath = req.getContextPath();
            String forwardURI = requestURI.substring(contextPath.length());
            System.out.println("requestURI:" + requestURI + ", contextPath:" + contextPath);
            session.setAttribute("viewPage", forwardURI);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/filter/logon.jsp");
            requestDispatcher.forward(req, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
        filterConfig = null;
    }

}
