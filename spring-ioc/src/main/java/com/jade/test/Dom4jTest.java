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

public class Dom4jTest {

    private boolean flag = true;

    public static void main(String[] args) throws DocumentException {


        new Dom4jTest().test001();


    }

    public void test001() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getXmlPath("student.xml")); //student.xml
        Element rootElement = document.getRootElement();
        getNodes(rootElement);
    }

    public void getNodes(Element element){

        if(flag){
            System.out.println("noteName=" + element.getName());
            flag = false;
        }else{
            System.out.print("noteName=" + element.getName());
        }


        //        获取属性value
        String nodeValue = element.getTextTrim();
        if(StringUtils.isNotEmpty(nodeValue)){
            System.out.println("    nodeValue="+  nodeValue);
        }

        List<Attribute> attributes = element.attributes();
        for (Attribute attribute: attributes) {
            String key = attribute.getName();
            String value = attribute.getText();
            System.out.println("  key="+key+" value="+value);
        }

        Iterator<Element> elementIterator = element.elementIterator();
        while (elementIterator.hasNext()){
            Element nextElement = elementIterator.next();
            getNodes(nextElement);
        }

    }



    /**
     *  获取资源输入流
     * @param xmlPath 资源路径
     * @return 文件流
     */
    public InputStream getXmlPath(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;
    }


}
