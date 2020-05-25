package com.mxingo.getui.platform.demo.test;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.base.payload.MultiMedia;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.mxingo.getui.platform.demo.constant.AppInfo.push;

public class SinglePushTest {


    private static String cid = "ce018bb633066839fd0d6fb448bfcb23";
    private static String appId = "rTBlL1Md7W54v0bap7jPp6";

    private static String appKey = "D5xdzX9Kk19S2M5VyyYOz8";
    private static String masterSecret = "Nk62hr2nG568NQg74CZdm4";
//    private static String masterSecret = "8OKkZGiruR7ov0j1wjh5q7";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    /*
    #define kGtAppId           @"rTBlL1Md7W54v0bap7jPp6"
    #define kGtAppKey          @"D5xdzX9Kk19S2M5VyyYOz8"
    #define kGtAppSecret       @"8OKkZGiruR7ov0j1wjh5q7"
    */


    public static void main(String[] args) {

        IGtPush push = new IGtPush(url, appKey, masterSecret);

        TransmissionTemplate template = getTemplate();

        // STEP5：定义"AppMessage"类型消息对象,设置推送消息有效期等推送参数
        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true); // 用户当前不在线时，是否离线存储，可选，默认不存储
        message.setOfflineExpireTime(1000 * 600);  //离线有效时间，单位为毫秒，可选

        // STEP6：执行推送
        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());


    }

    public static TransmissionTemplate getTemplate() {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 透传内容
        template.setTransmissionContent("任行透传内容测试-12-不必关心，打扰了");
        template.setTransmissionType(2);
        template.setTransmissionContent("任行透传内容测试-22-不必关心，打扰了"); //透传内容
        template.setAPNInfo(getAPNPayload()); //ios消息推送
        //template.setAPNInfo(getVoIPPayload());
        return template;
    }

    private static APNPayload getAPNPayload() {
        APNPayload payload = new APNPayload();
        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge("+1");
        payload.setContentAvailable(0);
        //ios 12.0 以上可以使用 Dictionary 类型的 sound
        payload.setSound("default");
//        payload.setCategory("$由客户端定义");
//        payload.addCustomMsg("由客户自定义消息key", "由客户自定义消息value");

        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //payload.setAlertMsg(getDictionaryAlertMsg());  //字典模式使用APNPayload.DictionaryAlertMsg

        //设置语音播报类型，int类型，0.不可用 1.播放body 2.播放自定义文本
        payload.setVoicePlayType(2);
        //设置语音播报内容，String类型，非必须参数，用户自定义播放内容，仅在voicePlayMessage=2时生效
        //注：当"定义类型"=2, "定义内容"为空时则忽略不播放
        payload.setVoicePlayMessage("您好");

        // 添加多媒体资源，可以是图片、音频、视频,最多可以添加3条多媒体
        //spayload.addMultiMedia(new MultiMedia().setResType(MultiMedia.MediaType.pic).setResUrl("资源文件地址").setOnlyWifi(true));

        return payload;
    }
}
