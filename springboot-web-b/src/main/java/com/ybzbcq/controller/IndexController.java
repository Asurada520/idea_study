package com.ybzbcq.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/b/")
public class IndexController {

//    setheader 这是响应头 允许跨域
/*    @RequestMapping("getBInfo")
    public Object  getInfo(HttpServletResponse response){
//        通知客户端（browser-浏览器）允许跨域 * 代表所有域名都是可以，在公司中正常的代码应该放入过滤器中
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("retCode","200");
        resultMap.put("retMsg","操作成功");
        return resultMap;
    }*/

//   jsonp 解决网站跨域问题
//    @RequestMapping("getBInfo")
//    public void getInfo(HttpServletResponse response, String jsonpCallback) throws IOException {
//        response.setHeader("Content-type", "text/html;charset=UTF-8");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("retCode", "200");
//        jsonObject.put("retMsg", "操作成功");
//        PrintWriter writer = response.getWriter();
//        writer.println(jsonpCallback + "(" + jsonObject.toJSONString() + ")");
//    }

    //    setheader 这是响应头 允许跨域
    @RequestMapping("getBInfo")
    public Object  getInfo(HttpServletResponse response){
//        通知客户端（browser-浏览器）允许跨域 * 代表所有域名都是可以，在公司中正常的代码应该放入过滤器中
//        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("retCode","200");
        resultMap.put("retMsg","操作成功");
        return resultMap;
    }

}
