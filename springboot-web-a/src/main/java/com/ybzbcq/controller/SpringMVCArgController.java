package com.ybzbcq.controller;


import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/arg/")
public class SpringMVCArgController {

    private  static  final Logger logger = LoggerFactory.getLogger(SpringMVCArgController.class);

    @PostMapping(value = "/post")
    public String post(@RequestParam(name = "name") String name,
                       @RequestParam(name = "age") Integer age,
                        HttpServletRequest request) {

        StringBuffer requestURL = request.getRequestURL();

        logger.info("url:" + requestURL);
        String content = String.format("name = %s,age = %d", name, age);
        logger.info(content);
        return content;
    }

}
