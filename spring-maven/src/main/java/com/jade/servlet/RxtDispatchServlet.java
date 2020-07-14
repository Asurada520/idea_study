package com.jade.servlet;

import com.jade.annotation.ExtController;
import com.jade.annotation.ExtRequestMapping;
import com.jade.utils.ClassUtil;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "RxtDispatchServlet")
public class RxtDispatchServlet extends HttpServlet {

    // springmvc 容器对象 key:类名id ,value 对象
    private ConcurrentHashMap<String, Object> springmvcBeans = new ConcurrentHashMap<String, Object>();
    // springmvc 容器对象 keya:请求地址 ,vlue类
    private ConcurrentHashMap<String, Object> urlBeans = new ConcurrentHashMap<String, Object>();
    // springmvc 容器对象 key:请求地址 ,value 方法名称
    private ConcurrentHashMap<String, String> urlMethods = new ConcurrentHashMap<String, String>();


    @Override
    public void init() throws ServletException {
        // 1.获取当前包下所有的类
        List<Class<?>> classes = ClassUtil.getClasses("com.jade.controller");

        try {
            // 2.将扫包范围所有的类,注入到springmvc容器里面，存放在Map集合中 key为默认类名小写，value 对象
            getClassMVCAnnotation(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3.将url映射和方法进行关联
        handlerMapping();


    }

    // 3.将url映射和方法进行关联
    public void handlerMapping() {
        for (Map.Entry<String, Object> mvcBean : springmvcBeans.entrySet()) {
            Object object = mvcBean.getValue();
            Class<? extends Object> clazz = object.getClass();
            ExtRequestMapping extRequestMapping = clazz.getDeclaredAnnotation(ExtRequestMapping.class);

            String baseUrl = "";
            if(extRequestMapping != null){
                baseUrl = extRequestMapping.value();
                System.out.println("baseURL:" + baseUrl);
            }
            Method[] methods = clazz.getDeclaredMethods();
            if(methods != null){
                for (Method method: methods) {
                    ExtRequestMapping declaredAnnotation = method.getDeclaredAnnotation(ExtRequestMapping.class);
                    if(declaredAnnotation != null){
                        String methodUrl = baseUrl + declaredAnnotation.value();
                        System.out.println("methodURL:" + methodUrl);
                        urlBeans.put(methodUrl, object);
                        urlMethods.put(methodUrl,method.getName());
                    }
                }
            }

        }

    }

    /**
     * 将扫包范围所有的类,注入到springmvc容器里面，存放在Map集合中 key为默认类名小写，value 对象
     *
     * @param classes
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private void getClassMVCAnnotation(List<Class<?>> classes) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (classes != null) {
            for (Class<?> clazz : classes) {

                ExtController extController = clazz.getDeclaredAnnotation(ExtController.class);
                if (extController != null) {
                    String beanId = ClassUtil.toLowerCaseFirstOne(clazz.getSimpleName());
                    Object object = ClassUtil.newInstance(clazz);
                    springmvcBeans.put(beanId, object);
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if(StringUtils.isEmpty(requestURI)){
            return;
        }

        Object object = urlBeans.get(requestURI);
        PrintWriter out = response.getWriter();
        if(object == null){
            out.println("not found 404 url");
            return;
        }

        String methodName = urlMethods.get(requestURI);
        if(StringUtils.isEmpty(methodName)){
            out.println("not found method");
        }

        // java 反射机制 调用方法
        String resultPage = (String)methodInvoke(object, methodName);
        // 调用视图转换器 渲染页面展示
        extResourceViewResolver(resultPage,request,response);

    }

    private void extResourceViewResolver(String pageName, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // 根路径
        String prefix = "/";
        String suffix = ".jsp";
        req.getRequestDispatcher(prefix + pageName + suffix).forward(req, res);
    }


    // 反射调用方法
    private Object methodInvoke(Object object, String methodName) {
        try {
            Method method = object.getClass().getMethod(methodName);
            Object result = method.invoke(object);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
