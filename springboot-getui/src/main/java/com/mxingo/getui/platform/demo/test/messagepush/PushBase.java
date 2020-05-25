package com.mxingo.getui.platform.demo.test.messagepush;

import java.util.Date;

public abstract class PushBase {

    protected static final String APPID = "rTBlL1Md7W54v0bap7jPp6";
    protected static final String APPKEY = "D5xdzX9Kk19S2M5VyyYOz8";
    protected static final String MASTERSECRET = "Nk62hr2nG568NQg74CZdm4";
    protected static final String CLIENTID = "cf5c84987b020f9561ece0062f940f93";
    protected static final String API = "http://sdk.open.api.igexin.com/apiex.htm"; 	//OpenService接口地址

    protected static String getDate(){
        Date date = new Date();
        return date.toLocaleString();
    }
}
