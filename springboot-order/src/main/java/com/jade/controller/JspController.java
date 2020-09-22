package com.jade.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp/")
@Slf4j
public class JspController {

    @RequestMapping("go1")
    public String goJsp(){
        log.info("springboot access first jsp document.");
        return "jspIndex";
    }

}
