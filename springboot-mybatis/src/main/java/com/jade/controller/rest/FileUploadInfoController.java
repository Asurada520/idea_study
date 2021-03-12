package com.jade.controller.rest;


import com.jade.service.FileUploadInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload/")
public class FileUploadInfoController {

    @Autowired
    private FileUploadInfoService fileUploadInfoService;

    @RequestMapping("get")
    public Object getInfo(){
        return fileUploadInfoService.getInfo();
    }
}
