package com.jade.aop;


import com.jade.annotation.ExtAPIToken;
import com.jade.annotation.ExtApiIdempotent;
import com.jade.common.ConstantUtils;
import com.jade.utils.RedisToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Aspect
@Component
@Slf4j
public class APIIdempotentAop {

    @Autowired
    private RedisToken redisToken;

    @Pointcut("execution(public * com.jade.controller.*.*(..))")
    public void apiAOP() {
    }


    @Before("apiAOP()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        ExtAPIToken extAPITokenAnnotation = signature.getMethod().getDeclaredAnnotation(ExtAPIToken.class);
        if (extAPITokenAnnotation != null) {
            String token = redisToken.getToken();
            getRequest().setAttribute("token",token);
        }

    }


    @Around("apiAOP()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        ExtApiIdempotent extApiIdempotent = signature.getMethod().getDeclaredAnnotation(ExtApiIdempotent.class);
        if (extApiIdempotent == null) {
            return proceedingJoinPoint.proceed();
        }

        String type = extApiIdempotent.type();
        HttpServletRequest request = getRequest();

        String token = null;

        if (type.equals(ConstantUtils.EXTAPIHEAD)) {
            token = request.getHeader("token");
        } else {
            token = request.getParameter("token");
        }

        if (StringUtils.isEmpty(token)) {
            return "token 参数异常";
        }
        boolean isToken = redisToken.findToken(token);
        if (!isToken) {
            response("请勿重复提交");
            return null;
        }

        return proceedingJoinPoint.proceed();
    }

    private void response(String msg) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }
}
