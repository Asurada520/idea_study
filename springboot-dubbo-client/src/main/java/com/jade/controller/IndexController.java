package com.jade.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jade.service.IndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dubbo/")
@RestController
public class IndexController {


    @Reference(version = "1.0.0",timeout = 300)
    private IndexService indexService;

    @RequestMapping("index")
    public Object index(){
        String index = indexService.index();
        return index;
    }
}
