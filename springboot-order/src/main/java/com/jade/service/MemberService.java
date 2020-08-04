package com.jade.service;

import com.alibaba.fastjson.JSONObject;
import com.jade.utils.HttpClientUtils;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public  JSONObject getMember(){
        JSONObject jsonObject = HttpClientUtils.httpGet("http://127.0.0.1:8081/member/index");
        return jsonObject;
    }

}
