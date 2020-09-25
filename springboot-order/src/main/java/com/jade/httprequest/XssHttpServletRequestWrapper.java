package com.jade.httprequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        if (StringUtils.isNotEmpty(name)) {
            parameter = StringEscapeUtils.escapeHtml(parameter);
        }
        return parameter;
    }
}
