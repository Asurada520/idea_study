package com.jade.controller;


import com.jade.enmu.RespCodeDefine;
import com.jade.entity.MAppEntity;
import com.jade.entity.ResponseEntity;
import com.jade.service.AppService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private AppService appService;

    @RequestMapping("token")
    public Object getToken(MAppEntity mAppEntity){
        ResponseEntity responseEntity = null;

        // args 参数检查
        String app_id = mAppEntity.getApp_id();
        String app_secret = mAppEntity.getApp_secret();
        if(StringUtils.isEmpty(app_id)||StringUtils.isEmpty(app_secret)){
            responseEntity = new ResponseEntity(RespCodeDefine.ARGS_EXCEPTION);
            responseEntity.setData("app_id or app_secret is null");
        }

        MAppEntity appEntity = appService.getInfoByIdAndSecret(mAppEntity);

        responseEntity = new ResponseEntity(RespCodeDefine.SUCCESS);

        return responseEntity;
    }

}
