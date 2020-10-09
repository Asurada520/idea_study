package com.jade.service;

import com.jade.dao.MAppMapper;
import com.jade.entity.MAppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private MAppMapper mAppMapper;

    public MAppEntity getInfoByIdAndSecret(MAppEntity mAppEntity){
        return mAppMapper.getInfoByIdAndSecret(mAppEntity);
    }

    public int updateInfoById(MAppEntity appEntity){
        int i = mAppMapper.updateInfoById(appEntity);
        return i;
    }

}
