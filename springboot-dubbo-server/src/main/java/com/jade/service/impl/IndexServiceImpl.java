package com.jade.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jade.service.IndexService;

@Service(version = "1.0.0",timeout = 3000)
public class IndexServiceImpl implements IndexService {
    @Override
    public String index() {
        return "successful";
    }
}
