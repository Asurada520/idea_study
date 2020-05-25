package com.jade.filter;

import com.jade.http.MultipartRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
* 文件上传 透明传输 重写 request 对象 实现 普通字段和文件字段分开进行处理
* */
@WebFilter(filterName = "UploadFilter")
public class UploadFilter implements Filter {

    long sizeMax = 0;
    int sizeThreshold = 0;
    String repositoryPath = null;
    String headerEncoding = null;

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("doFilter 过滤器起作用了");

        HttpServletRequest req = (HttpServletRequest) request;
        String type = req.getHeader("Content-Type");

        if (type == null || !type.startsWith("multipart/form-data")) {
            chain.doFilter(request, response);

        } else {
            MultipartRequest multipartRequest = null;
            try {
                multipartRequest = new MultipartRequest(req);
            } catch (Exception e) {
                throw new ServletException(e);
            }
            chain.doFilter(multipartRequest, response);

        }

    }


    public void destroy() {
        filterConfig = null;
    }
}
