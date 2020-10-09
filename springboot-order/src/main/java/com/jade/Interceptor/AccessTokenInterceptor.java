package com.jade.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jade.config.RedisConfig;
import com.jade.enmu.RespCodeDefine;
import com.jade.entity.ResponseEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.applet.resources.MsgAppletViewer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AccessTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisConfig redisConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("---------------------开始进入请求地址拦截----------------------------");

        String accessToken = request.getHeader("accessToken");
        System.out.println("accessToken:" + accessToken);
        if (StringUtils.isEmpty(accessToken)) {
            resultError("AccessToken is null", response);
            return false;
        }

        String value = (String) redisConfig.getValue(accessToken);
        if (StringUtils.isEmpty(value)) {
            resultError("AccessToken is gone", response);
            return false;
        }
        // 正常业务逻辑

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("---------------视图渲染之后的操作-------------------------0");
        String accessToken = request.getHeader("accessToken");
        redisConfig.delKey(accessToken);

    }

    // 返回错误提示
    public void resultError(String errorMsg, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        ResponseEntity responseEntity = new ResponseEntity(RespCodeDefine.ERROR, errorMsg);
        printWriter.write(new JSONObject().toJSONString(responseEntity));
    }
}
