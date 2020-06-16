package com.jade.conf;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.List;

public class ExtClassPathXmlApplicationContext {

    // xml path
    private String xmlPath;

    public ExtClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    // 获取配置文件
    public Object getBean(String beanId) throws Exception {

        if(StringUtils.isEmpty(beanId)){
            throw  new Exception("BeanId is null");
        }

        List<Element> elements = getElements();
        if (elements == null) return null;

        String classPath = getClassPath(beanId, elements);

        // 初始化对象
        if(StringUtils.isNotEmpty(classPath)){
            Object object = getObject(classPath);
            return object;
        }

        return null;


    }

    // 初始化对象
    private Object getObject(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

    private String getClassPath(String beanId, List<Element> elements) throws Exception {

        String classPath = null;

        for (Element element : elements) {
            String id = element.attributeValue("id");
            if(StringUtils.isEmpty(id)){
                continue;
            }
            if(id.equals(beanId)){
                classPath = element.attributeValue("class");
            }else{
                throw new Exception(beanId +", BeanId is not exist");
            }
        }
        return classPath;
    }

    // 解析配置文件
    private List<Element> getElements() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getXmlInputStream());
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        if(CollectionUtils.isEmpty(elements)){
            return null;
        }
        return elements;
    }

    public InputStream getXmlInputStream() throws Exception {
        if(StringUtils.isEmpty(xmlPath)){
            throw new Exception("xml path is null");
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;
    }




}
