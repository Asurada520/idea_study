package com.jade.dao;

import com.jade.entity.MAppEntity;

public interface MAppMapper {

    public MAppEntity getInfoByIdAndSecret(MAppEntity appEntity);

    public int updateInfoById(MAppEntity appEntity);

}
