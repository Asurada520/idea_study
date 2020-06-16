package com.jade.test;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test2 {

    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        String cityName = null;
        Scanner input = new Scanner(System.in);
        System.out.println("您要查询哪个城市的天气? ");
        cityName = input.nextLine();
        System.out.println("请稍等, 正在玩命查询中...");
        //1.    创建一个网址
        URL url = new URL("http://v.juhe.cn/weather/index?cityname="
                +cityName +"&dtype=xml&key=aea4e5f4f182a14702609eb72596b98c");
        //2.    连接服务器
        URLConnection conn = url.openConnection();
        //3.    得到输入流
        InputStream is = conn.getInputStream();
//1.    得到一个指向XML文档的 输入流

//2.    创建一个XML读取对象(SAXReader), 用于读取上述的输入流
        SAXReader sr = new SAXReader();
//3.    通过读取对象, 读取XML文档的 输入流, 得到文档对象(Document)
        Document doc = sr.read(is);
//4.    通过文档对象, 得到整个文档的 根元素对象(Element)
        Element root = doc.getRootElement();

        System.out.println("root:" + root);

        getNodes(root);

//5.    通过根元素 , 得到其它层次的所有元素对象
        String resultCode = root.elementText("resultcode");
        if ("200".equals(resultCode)) {

            System.out.println("resultCode:" + resultCode);


            //查询成功
            Element result = root.element("result");
            Element today = result.element("today");

            String text1 = today.elementText("date_y");
            String text2 = today.elementText("week");
            String text3 = today.elementText("weather");
            String text4 = today.elementText("temperature");
            String text5 = today.elementText("dressing_advice");
            System.out.println("您查询的城市天气如下:");
            System.out.println(text1 +" "+text2+" "+text3 +" 温度区间:"+text4+" 穿衣建议:"+text5);

            //包含七天天气信息的 元素
            Element future = result.element("future");
            List<Element> dates = future.selectNodes("//date");
            List<Element> weeks = future.selectNodes("//week");
            List<Element> weathers = future.selectNodes("//weather");
            List<Element> temperatures = future.selectNodes("//temperature");

            for (int i = 0; i < dates.size(); i++) {
                System.out.println("未来第"+i+"天的天气:");
                System.out.print("日期:"+dates.get(i).getText());
                System.out.print("\t"+weeks.get(i+1).getText());
                System.out.print("\t"+weathers.get(i+1).getText());
                System.out.print("\t"+temperatures.get(i+1).getText());
                System.out.println();
            }
        }else {
            //查询失败
            System.out.println("查询失败");
        }



    }


    public static void getNodes(Element element) {

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
}
