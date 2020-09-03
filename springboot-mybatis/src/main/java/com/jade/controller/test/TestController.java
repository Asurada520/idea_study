package com.jade.controller.test;


import com.jade.dao.DriverFlowDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/")
public class TestController {

    @Autowired
    private DriverFlowDayMapper driverFlowDayMapper;

    @RequestMapping("get")
    public Object getInfo(){

        List list = new ArrayList();
        list.add("5127291165422020-08-17");
        List<Map> infoByDriverCodeAndTime = driverFlowDayMapper.getInfoByDriverCodeAndTime(list);
        return infoByDriverCodeAndTime;
    }

}
