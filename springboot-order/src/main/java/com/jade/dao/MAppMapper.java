package com.jade.dao;

import com.jade.entity.MAppEntity;

public interface MAppMapper {

    public MAppEntity getInfoByIdAndSecret(String app_id, String app_secret);

}
