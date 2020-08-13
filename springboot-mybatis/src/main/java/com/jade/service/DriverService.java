package com.jade.service;


import com.jade.dao.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;


    public List<Map> getDriver(){
        return driverMapper.getDriver();
    }

    public int batchInsert(List<Map> list){
        int i = driverMapper.batchInsertList(list);
        return i;
    }
}
