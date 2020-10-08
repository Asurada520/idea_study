package com.jade.enmu;

public enum RespCodeDefine {
	
    SUCCESS(0, "请求成功"),
    ERROR(-1, "服务异常"),

    LOGIN_ERR(-2,"账号或密码有误"),
    LOGIN_REDO(-3,"session超时，请重新登陆"),
    LOGIN_YET(-4,"该账号已经登陆，请勿重复登陆"),

    NO_USER(-51,"用户不存在"),
    
    NO_PERMISSION(-1024,"权限不足"),
    UNAUTHENTICATED(-1023, "未登录"),

    ARGS_EXCEPTION(6001,"请求参数异常"),
	CONTROL_ERR(-104,"采集server状态异常");

    private int code;
    private String msg;

    RespCodeDefine(int code, String msg) {
    	this.code =code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
