package com.jade.service;

import com.jade.dao.GaoDeBillOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GaoDeBillOrderService {

    @Autowired
    private GaoDeBillOrderMapper gaoDeBillOrderMapper;

    public int batchInsert(List<Map> list){
        int i = gaoDeBillOrderMapper.batchInsertList(list);
        return i;
    }
}
