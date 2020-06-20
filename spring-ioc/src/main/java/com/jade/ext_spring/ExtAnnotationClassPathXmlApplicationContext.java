package com.jade.ext_spring;

import com.jade.annotation.ExtService;
import com.jade.utils.ClassUtil;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ExtAnnotationClassPathXmlApplicationContext {

    private String packageName;

    private static ConcurrentHashMap<String, Object> initBean = null;

    public ExtAnnotationClassPathXmlApplicationContext(String packageName) {
        this.packageName = packageName;
    }

    // java 反射机制 扫包，获取当前包下所有的类
    // 判断类上是否存在注入Bean的注解
    // java 反射机制，初始化对象

    public Object getBean(String beanId) throws Exception {

        // ava 反射机制 扫包，获取当前包下所有的类
        if(StringUtils.isEmpty(packageName)){
            throw new Exception("package is Null");
        }
        List<Class<?>> classesList = ClassUtil.getClasses(packageName);

        System.out.println("ClassesList : " + classesList);

        List<Class<?>> existAnnotationClassList =  new ArrayList<>();

        for (Class clazz : classesList) {
            Annotation extServiceAnnotation = clazz.getDeclaredAnnotation(ExtService.class);
            if(extServiceAnnotation == null){
                continue;
            }
            existAnnotationClassList.add(clazz);
        }

        if(CollectionUtils.isEmpty(existAnnotationClassList)){
            throw new Exception("Beans initialized is not found");
        }


        // clazz Object initialized
        initBean  = new ConcurrentHashMap<String, Object>();
        for (Class<?> clazz : existAnnotationClassList) {
            Object newInstance = clazz.newInstance();
            String simpleName = clazz.getSimpleName();
            String beanIdTemp = toLowerCaseFirstOne(simpleName);
            initBean.put(beanIdTemp,newInstance);
        }

        Object object = initBean.get(beanId);
        if(object == null){
            throw new Exception("Object not found by BeanId " + beanId);
        }
        return object;

    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
