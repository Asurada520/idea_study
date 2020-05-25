package com.mxingo.getui.platform.demo.test.messagepush;

import com.gexin.fastjson.JSONObject;
import com.gexin.rp.sdk.base.IIGtPush;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.base.payload.MultiMedia;
import com.gexin.rp.sdk.base.payload.VoIPPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;


/**
 * 对单个app的单个用户进行推送
 *
 * 对单个用户推送
 *
 */
public class PushMessageToSingleTest extends PushBase {
    public static void main(String[] args) {

        // 推送主类
        IIGtPush push = new IGtPush(API, APPKEY, MASTERSECRET);

        try {
            //单推消息类型
            SingleMessage message = new SingleMessage();

            //通知模版：支持TransmissionTemplate、LinkTemplate、NotificationTemplate，此处以TransmissionTemplate为例
            //数据经SDK传给您的客户端，由您写代码决定如何处理展现给用户
//            TransmissionTemplate template = new TransmissionTemplate();//透传方式
            TransmissionTemplate template = getTemplate();//透传方式
//            template.setAppId(APPID);
//            template.setAppkey(APPKEY);
//            template.setTransmissionContent("您需要透传的内容:" + getDate());

            //收到消息是否立即启动应用，1为立即启动，2则广播等待客户端自启动
//            template.setTransmissionType(1);

            message.setData(template);
//			message.setOffline(true);					//用户当前不在线时，是否离线存储,可选
//			message.setOfflineExpireTime(72 * 3600 * 1000);	//离线有效时间，单位为毫秒，可选

            Target target1 = new Target();
            target1.setAppId(APPID);
            target1.setClientId(CLIENTID);

            //单推
            IPushResult ret = push.pushMessageToSingle(message, target1);

            System.out.println(ret.getResponse().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static TransmissionTemplate getTemplate() {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(APPID);
        template.setAppkey(APPKEY);
        template.setTransmissionContent("透传内容测试1");

        /*
        搭配transmissionContent使用，可选值为1、2；
        1：立即启动APP（不推荐使用，影响客户体验）
        2：客户端收到消息后需要自行处理
        */
        template.setTransmissionType(2);

        template.setTransmissionContent("透传内容测试2"); //透传内容
        template.setAPNInfo(getAPNPayload()); //ios消息推送
        //template.setAPNInfo(getVoIPPayload());
        return template;
    }

    private static APNPayload getAPNPayload() {
        // 普通消息推送
        APNPayload payload = new APNPayload();
        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge("+1");
        payload.setContentAvailable(0);
        //ios 12.0 以上可以使用 Dictionary 类型的 sound
        payload.setSound("default");
        payload.setCategory("$由客户端定义");
        payload.addCustomMsg("由客户自定义消息key", "由客户自定义消息value");

        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //payload.setAlertMsg(getDictionaryAlertMsg());  //字典模式使用APNPayload.DictionaryAlertMsg

        //设置语音播报类型，int类型，0.不可用 1.播放body 2.播放自定义文本
        payload.setVoicePlayType(2);
        //设置语音播报内容，String类型，非必须参数，用户自定义播放内容，仅在voicePlayMessage=2时生效
        //注：当"定义类型"=2, "定义内容"为空时则忽略不播放
        payload.setVoicePlayMessage("定义内容");

        // 添加多媒体资源
        payload.addMultiMedia(new MultiMedia().setResType(MultiMedia.MediaType.pic)
                .setResUrl("资源文件地址")
                .setOnlyWifi(true));

        return payload;
    }

    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg() {
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setBody("body1");
        alertMsg.setActionLocKey("显示关闭和查看两个按钮的消息");
        alertMsg.setLocKey("loc-key1");
        alertMsg.addLocArg("loc-ary1");
        alertMsg.setLaunchImage("调用已经在应用程序中绑定的图形文件名");
        // iOS8.2以上版本支持
        alertMsg.setTitle("通知标题");
        alertMsg.setTitleLocKey("自定义通知标题");
        alertMsg.addTitleLocArg("自定义通知标题组");
        return alertMsg;
    }

    /**
     * 需要使用iOS语音传输，请使用VoIPPayload代替APNPayload
     * @return
     */
    private static VoIPPayload getVoIPPayload() {
        VoIPPayload payload = new VoIPPayload();
        JSONObject jo = new JSONObject();
        jo.put("key1", "value1");
        payload.setVoIPPayload(jo.toString());
        return payload;
    }
}
