package com.jade.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    /**
     * setheader 这是响应头 允许跨域
     * 通知客户端（browser-浏览器）允许跨域 * 代表所有域名都是可以，在公司中正常的代码应该放入过滤器中
     *
     * @param response
     * @return
     */
    /*@RequestMapping("/bInfo")
    public Object bInfo(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> result = new HashMap<>();
        result.put("retCode","200");
        result.put("retMsg","success");
        return result;
    }*/

    @RequestMapping("/bInfo")
    public Object bInfo(HttpServletResponse response){
        Map<String, Object> result = new HashMap<>();
        result.put("retCode","200");
        result.put("retMsg","success");
        return result;
    }

    /**
     * 使用jsonp 解决跨域问题
     * @param response
     * @param jsonpCallback
     * @throws IOException
     */

   /* @RequestMapping("/bInfo")
    public void bInfo(HttpServletResponse response, String jsonpCallback) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        JSONObject result = new JSONObject();
        result.put("retCode", "200");
        result.put("retMsg", "success");
        PrintWriter writer = response.getWriter();

        writer.println(jsonpCallback + "(" + result.toJSONString() + ")");
        writer.close();

        return ;
    }*/

}
