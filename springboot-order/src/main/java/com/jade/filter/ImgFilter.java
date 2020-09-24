package com.jade.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "imgFilter",urlPatterns = "/imgs/*")
public class ImgFilter implements Filter {

    @Value("${domain.name}")
    private String domainName;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        String referer = request.getHeader("Referer");

        System.out.println("Referer:" + referer);

        if(StringUtils.isEmpty(referer)){
            req.getRequestDispatcher("/imgs/error.png").forward(request,resp);
            return;
        }

        String domain = getDomain(referer);

        System.out.println("domain: " + domain);

        if(!domain.equals(domainName)){
            req.getRequestDispatcher("/imgs/error.png").forward(request,resp);
            return;
        }

        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2)
                    startIndex = i;
                else if (j == 3)
                    endIndex = i;
            }

        }
        result = url.substring(startIndex + 1, endIndex);
        return result;
    }

}


// 图片防盗链
/*
@WebFilter(filterName = "imgFilter", urlPatterns = "/imgs/*")
public class ImgFilter implements Filter {
    @Value("${domain.name}")
    private String domainName;

    */
/*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     *//*

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    */
/*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     *//*

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 1.获取请求头中的来源字段
        HttpServletRequest req = (HttpServletRequest) request;
        String referer = req.getHeader("Referer");

        System.out.println("referer: " + referer);

        if (StringUtils.isEmpty(referer)) {
            request.getRequestDispatcher("/imgs/error.png").forward(req, response);
            return;
        }
        // 2.判断请求头中的域名是否和限制的域名一致
        String domainUrl = getDomain(referer);

        System.out.println("domainUrl: " + domainUrl);

        // 正常情况 黑名单 白名单接口
        if (!domainUrl.equals(domainName)) {
            request.getRequestDispatcher("/imgs/error.png").forward(req, response);
            return;
        }
        // 直接放行图片
        chain.doFilter(req, response);

    }

    */
/**
     * 获取url对应的域名
     *
     * @param url
     * @return
     *//*

    public String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2)
                    startIndex = i;
                else if (j == 3)
                    endIndex = i;
            }

        }
        result = url.substring(startIndex + 1, endIndex);
        return result;
    }

    */
/*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#destroy()
     *//*

    public void destroy() {
        // TODO Auto-generated method stub

    }

}*/
