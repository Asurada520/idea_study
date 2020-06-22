package com.ybzbcq.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class XMLTest {

    public static void main(String[] args) throws DocumentException {

        XMLTest xmlTest = new XMLTest();
        SAXReader saxReader = new SAXReader();
        InputStream resourceAsStream = xmlTest.getClass().getClassLoader().getResourceAsStream("students.xml");

        Document read = saxReader.read(resourceAsStream);
        Element rootElement = read.getRootElement();
        getNodes(rootElement);

    }

    public static void getNodes(Element rootElement) {
        System.out.println("获取当前名称:" + rootElement.getName());
        // 获取属性信息
        List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println("属性:" + attribute.getName() + " -- " + attribute.getText());
        }
        // 获取属性value
        String value = rootElement.getTextTrim();
        if (value != null && !"".equals(value)) {
            System.out.println("value:" + value);
        }
        // 使用迭代器遍历,继续遍历子节点
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }

    }
}