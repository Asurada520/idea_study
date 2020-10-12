package com.jade.test;

import com.alibaba.fastjson.JSONObject;
import com.jade.utils.HttpClientUtils;

import java.net.URLEncoder;

public class CodeTest {

    public static void main(String[] args) {

        String name = "1+1";
        String encode = URLEncoder.encode(name);

        String url = "http://localhost:9090/encode/do?name="+encode;

        JSONObject jsonObject = HttpClientUtils.httpGet(url);

        System.out.println("jsonObject: " + jsonObject);

    }

}
