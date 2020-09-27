package com.jade.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file/")
@Slf4j
public class FileUploadController {

    @RequestMapping("go")
    public String goUploadJsp(){
        return "uploadFile";
    }
}
