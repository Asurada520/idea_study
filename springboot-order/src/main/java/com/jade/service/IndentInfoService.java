package com.jade.service;

import com.jade.dao.IndentInfoMapper;
import com.jade.entity.IndentInfoEntity;
import com.jade.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentInfoService {

    @Autowired
    private IndentInfoMapper indentInfoMapper;

    public List<IndentInfoEntity> selectAll(){
        return indentInfoMapper.selectAll();
    }


    public int insert(IndentInfoEntity indentInfo){
        indentInfo.setId(UuidUtil.get18UUID());
        return indentInfoMapper.insert(indentInfo);
    }

}
