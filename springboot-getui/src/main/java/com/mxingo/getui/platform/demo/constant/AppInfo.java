package com.mxingo.getui.platform.demo.constant;

import com.gexin.rp.sdk.http.IGtPush;

/**
 * AppInfo 相关信息
 *
 * @author zhangwf
 * @see
 * @since 2019-07-09
 */
public class AppInfo {
    public static final String APPID = "rTBlL1Md7W54v0bap7jPp6";
    public static final String APPKEY = "D5xdzX9Kk19S2M5VyyYOz8";
    public static final String MASTERSECRET = "8OKkZGiruR7ov0j1wjh5q7";

    public static final String CID = "";
    public static final String CID_2 = "";

    public static final String DEVICETOKEN = "";

    public static final String ALIAS = "alias1";
    public static final String ALIAS_2 = "alias2";

    public static final String TAG = "tag1";
    public static final String TAG_2 = "tag2";

    public static final String PNMD5 = "xxxx";

    public static IGtPush push = new IGtPush(APPKEY, MASTERSECRET);

    public static final String url = "http://sdk.open.api.igexin.com/apiex.htm";
}
