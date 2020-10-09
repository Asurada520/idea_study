package com.jade.controller;


import com.alibaba.fastjson.JSONObject;
import com.jade.config.RedisConfig;
import com.jade.enmu.RespCodeDefine;
import com.jade.entity.MAppEntity;
import com.jade.entity.ResponseEntity;
import com.jade.service.AppService;
import com.jade.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private AppService appService;

    @Autowired
    private RedisConfig redisConfig;

    @RequestMapping("token")
    public Object getToken(MAppEntity mAppEntity){
        ResponseEntity responseEntity = null;

        // args 参数检查
        String app_id = mAppEntity.getApp_id();
        String app_secret = mAppEntity.getApp_secret();
        if(StringUtils.isEmpty(app_id)||StringUtils.isEmpty(app_secret)){
            responseEntity = new ResponseEntity(RespCodeDefine.ARGS_EXCEPTION);
            responseEntity.setData("app_id or app_secret is null");
            return responseEntity;
        }

        MAppEntity appEntity = appService.getInfoByIdAndSecret(mAppEntity);

        if(appEntity == null){
            responseEntity = new ResponseEntity(RespCodeDefine.NO_USER);
            responseEntity.setData("Business is not existed");
            return responseEntity;
        }

        String is_flag = appEntity.getIs_flag();
        if("1".equals(is_flag)){
            // NO_PERMISSION
            responseEntity = new ResponseEntity(RespCodeDefine.NO_PERMISSION);
            responseEntity.setData("Business auth is not enable.");
            return responseEntity;
        }

        //
        String accessToken = appEntity.getAccess_token();
        if(StringUtils.isNotEmpty(accessToken)){
            redisConfig.delKey(accessToken);
        }


        String token = getNewAccessToken(app_id, appEntity);

        responseEntity = new ResponseEntity(RespCodeDefine.SUCCESS);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accessToken",token);
        responseEntity.setData(jsonObject);

        return responseEntity;
    }

    private String getNewAccessToken(String app_id, MAppEntity appEntity) {
        String token = TokenUtils.getToken();
        redisConfig.setString(token,app_id,60*60*2L);

        MAppEntity mAppEntityUpdate = new MAppEntity();
        mAppEntityUpdate.setId(appEntity.getId());
        mAppEntityUpdate.setAccess_token(token);
        appService.updateInfoById(mAppEntityUpdate);

        return token;
    }

}
