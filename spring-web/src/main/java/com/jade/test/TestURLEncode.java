package com.jade.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/*中文字符的URL编码和解码*/
public class TestURLEncode {
    public static void main(String[] args) throws Exception {

        String utf8_url = URLEncoder.encode("中国", "utf-8");
        String gb2312_url = URLEncoder.encode("中国", "gb2312");

        System.out.println("中国的UTF-8码的URL编码为：" + utf8_url);
        System.out.println("中国的GB2312码的URL编码为：" + gb2312_url);
        System.out.println();

        System.out.println("解码：" + utf8_url + ", 按照UTF-8码进行URL解码的结果为：" + URLDecoder.decode(utf8_url,"utf-8"));
        System.out.println("解码：" + utf8_url + ", 按照ISO-8859-1码进行URL解码的结果为：" + URLDecoder.decode(utf8_url,"iso8859-1"));
        System.out.println();

        System.out.println("解码：" + gb2312_url + ", 按照GB2312码进行URL解码的结果为：" + URLDecoder.decode(gb2312_url,"gb2312"));
        System.out.println("解码：" + gb2312_url + ", 按照ISO-8859-1码进行URL解码的结果为：" + URLDecoder.decode(gb2312_url,"iso8859-1"));



        String cuuids = "1";
        String[] cuuidsArrray = cuuids.split(",");
        System.out.println(Arrays.toString(cuuidsArrray));

    }
}
