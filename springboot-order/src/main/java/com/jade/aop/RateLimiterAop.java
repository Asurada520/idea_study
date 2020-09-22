package com.jade.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.jade.annotation.ExtRateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class RateLimiterAop {

    private ConcurrentHashMap<String, RateLimiter> rateMap = new ConcurrentHashMap();

    @Pointcut("execution(public * com.jade.service.*.*(..))")
    public void rlAop(){}

    @Around("rlAop()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        ExtRateLimiter extRateLimiter = signature.getMethod().getAnnotation(ExtRateLimiter.class);

        if(extRateLimiter == null){
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        }

        double value = extRateLimiter.value();
        long timeOut = extRateLimiter.timeout();

        ServletRequestAttributes requestAttributes = getServletRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURI = request.getRequestURI();

        RateLimiter rateLimiter;
        if(rateMap.containsKey(requestURI)){
            rateLimiter = rateMap.get(requestURI);
        }else {
            rateLimiter = RateLimiter.create(value);
            rateMap.put(requestURI,rateLimiter);
        }

        boolean tryAcquire = rateLimiter.tryAcquire(timeOut, TimeUnit.MILLISECONDS);
        if(!tryAcquire){
            fallback();
            return null;
        }
        return proceedingJoinPoint.proceed();
    }

    private ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

//    private void fallback() {
//        System.out.println("系统服务繁忙，烦请过一段时间再重试，谢谢");
//        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
//        HttpServletResponse response = servletRequestAttributes.getResponse();
//        response.setHeader("Context-type", "text/html;charset=utf-8");
//        PrintWriter writer = null;
//        try {
//            writer = response.getWriter();
//            writer.println("系统服务繁忙，烦请过一段时间再重试，谢谢");
//        } catch (IOException e) {
//            e.printStackTrace();
//            writer.println("many");
//
//        }finally {
//            writer.close();
//        }
//
//    }

    private void fallback() throws IOException {
        System.out.println("服务降级别抢了， 在抢也是一直等待的， 还是放弃吧！！！");
        // 在AOP编程中获取响应
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("别抢了， 在抢也是一直等待的， 还是放弃吧！！！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();

        }

    }

}
