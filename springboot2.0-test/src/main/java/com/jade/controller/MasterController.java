package com.jade.controller;

import com.jade.common.ElectionMaster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 选举策略 项目工程 测试
 */
@RestController
@RequestMapping("/master/")
public class MasterController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("go")
    public Object getServerInfo() {
        String isSurvivalDesc = ElectionMaster.isSurvival ? "选举为主服务器" : "该服务器为从服务器";
        return "server port:" + serverPort + ", isSurvivalDesc:" + isSurvivalDesc;
    }

}
