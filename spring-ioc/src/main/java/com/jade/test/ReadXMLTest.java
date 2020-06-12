package com.jade.test;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 * @Description 读取XML文件内容
 * @since 2019-09-10 14:12
 */

public class ReadXMLTest {

    public static void main(String[] args) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        InputStream inputStream = new ReadXMLTest().getClassPath("student.xml");

        Document read = saxReader.read(inputStream);

        Element rootElement = read.getRootElement();

        getNodes(rootElement);
//        System.out.println(rootElement.getName() + " " + rootElement.getText());
    }

    public InputStream getClassPath(String xmlPath) {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
        return resourceAsStream;
    }

    public static void getNodes(Element element) {

        System.out.println("当前节点名称：" + element.getName());

//        获取属性信息
        List<Attribute> attributes = element.attributes();

        for (Attribute attribute : attributes) {
            System.out.println("属性名称：" + attribute.getName() + " --- " + attribute.getText());
        }

//        获取属性value
        String value = element.getTextTrim();

        if(StringUtils.isNotEmpty(value)){
            System.out.println("当前节点值: "+  value);
        }

        Iterator<Element> elementIterator = element.elementIterator();
        while (elementIterator.hasNext()){
            Element nextElement = elementIterator.next();
            getNodes(nextElement);
        }


    }

}