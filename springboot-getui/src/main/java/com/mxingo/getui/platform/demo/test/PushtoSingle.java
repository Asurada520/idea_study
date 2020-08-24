package com.mxingo.getui.platform.demo.test;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

public class PushtoSingle {

    /*
    *   #define kGtAppId           @"rTBlL1Md7W54v0bap7jPp6"
        #define kGtAppKey          @"D5xdzX9Kk19S2M5VyyYOz8"
        #define kGtAppSecret       @"8OKkZGiruR7ov0j1wjh5q7"
    *
    * */

    // 详见【概述】-【服务端接入步骤】-【STEP1】说明，获得的应用配置
    private static String appId = "rTBlL1Md7W54v0bap7jPp6";
    private static String appKey = "D5xdzX9Kk19S2M5VyyYOz8";
    private static String masterSecret = "Nk62hr2nG568NQg74CZdm4";

    static String CID = "606102f9acac3d218625a0e6075791d4";
    //
    // 别名推送方式
//     static String Alias = "15251707110";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) throws Exception {
        // 设置后，根据别名推送，会返回每个cid的推送结果
//        System.setProperty(Constants.GEXIN_PUSH_SINGLE_ALIAS_DETAIL, "true");
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        NotificationTemplate template = getNotificationTemplate();
        SingleMessage message = new SingleMessage();

        message.setOffline(false);
        // 离线有效时间，单位为毫秒
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        // 厂商通道下发策略
        message.setStrategyJson("{\"default\":4,\"ios\":4,\"st\":4}");
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(CID);
//        target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }

    public static NotificationTemplate getNotificationTemplate() {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("请输入通知栏标题");
        style.setText("请输入通知栏内容");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        style.setChannel("通知渠道id");
        style.setChannelName("通知渠道名称");
        style.setChannelLevel(3); //设置通知渠道重要性
        template.setStyle(style);

        template.setTransmissionType(1);  // 透传消息接受方式设置，1：立即启动APP，2：客户端收到消息后需要自行处理
        template.setTransmissionContent("{\"title\" : \"任行约车司机端\",\"msg\" : \"你有新的车队订单，请及时接单\",\"order\" : {\"bookDays\":0,\"bookTime\":\"2020-08-31 21:00:00\",\"carLevel\":1,\"carNo\":\"苏Q35665\",\"driverNo\":\"257aa43e3e834ea0bd\",\"endAddr\":\"苏州市姑苏区和基广场-地上停车场\",\"endLat\":31.314591,\"endLon\":120.638144,\"orderAmount\":100,\"orderModel\":1,\"orderNo\":\"202008241647504513\",\"orderStatus\":1,\"orderType\":1,\"orgId\":\"ffcf2166b02642e4bf\",\"passengerMobile\":\"15696164096\",\"passengerName\":\"任2\",\"payAmount\":0,\"planMileage\":84349,\"remark\":\" 1\\r\\n\\t\\t\\t\\t\\r\\n\\t\\t\\t\",\"source\":9,\"startAddr\":\"上海市闵行区上海虹桥国际机场-T2航站楼\",\"startLat\":31.200811,\"startLon\":121.333905,\"tripNo\":\"111111\",\"usrId\":0},\"taskId\" : \"2020082417024155867\",\"pushType\" : \"10000\"}");

        //template.setAPNInfo(getAPNPayload()); //详见【推送模板说明】iOS通知样式设置
        return template;
    }

}
