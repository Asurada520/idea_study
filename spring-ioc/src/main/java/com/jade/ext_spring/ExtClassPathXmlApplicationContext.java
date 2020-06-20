package com.jade.ext_spring;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.List;

public class ExtClassPathXmlApplicationContext {

    /**
     * 1.读取配置文件
     * 2.初始化参数
     */

    private String xmlPath;

    public ExtClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws Exception {

        if (StringUtils.isEmpty(beanId)) {
            throw new Exception("Bean id is null");
        }
        // 1. 解析xml文件，获取bean节点信息
        Element rootElement = getRootElement();
        String classPath = getClassPath(beanId, rootElement);
        if(StringUtils.isEmpty(classPath)){
            throw new Exception("Class not found");
        }

        Object object = getObject(classPath);
        return object;
    }

    private Element getRootElement() throws Exception {

        if(StringUtils.isEmpty(xmlPath)){
            throw new Exception("xml path is null");
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        return document.getRootElement();
    }

    private String getClassPath(String beanId, Element rootElement) throws Exception {
        String classPath = null;
        List<Element> elements = rootElement.elements();

        if(CollectionUtils.isEmpty(elements)){
            throw new Exception("Beans is null in the configuration file.");
        }

        for (Element element : elements) {
            String beanIdValue = element.attributeValue("id");
            if (!beanIdValue.equals(beanId)) {
                continue;
            }
            classPath = element.attributeValue("class");

        }
        return classPath;
    }

    private Object getObject(String xmlClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(xmlClass);
        return clazz.newInstance();
    }

}
