package com.jade.entity;


import com.jade.enmu.RespCodeDefine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回模版
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseEntity {
//     状态码
    private int code;
//    状态描述
    private String msg;
//    数据信息
    private Object data;


    public ResponseEntity(RespCodeDefine respCodeDefine){
        this.code = respCodeDefine.getCode();
        this.msg = respCodeDefine.getMsg();
    }

    public ResponseEntity(RespCodeDefine respCodeDefine, Object data){
        this(respCodeDefine);
        this.data =  data;
    }

}
