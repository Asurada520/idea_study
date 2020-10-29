package com.jade.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *  全局捕获异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(){
        Map<String,Object> map = new HashMap<>();
        map.put("code","101");
        map.put("msg","system error");
        return map;
    }
}
