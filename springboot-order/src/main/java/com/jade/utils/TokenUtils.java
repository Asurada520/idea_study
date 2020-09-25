package com.jade.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenUtils {

    static Map<String, Object> tokenMap = new ConcurrentHashMap<>();


    public synchronized static String getToken() {
        String token = "token-" + System.currentTimeMillis();
        tokenMap.put(token, token);
        return token;
    }

    public static boolean findToken(String token){

        if(StringUtils.isEmpty(token)){
            return false;
        }

        boolean flag = tokenMap.containsKey(token);
        if(flag){
            tokenMap.remove(token);
            return true;
        }else{
            return false;
        }

    }

}
