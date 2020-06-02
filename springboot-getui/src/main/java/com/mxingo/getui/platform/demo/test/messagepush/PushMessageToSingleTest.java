package com.mxingo.getui.platform.demo.test.messagepush;

import com.gexin.fastjson.JSON;
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

        String jsonStr = "{\"title\" : \"任行出行\",\"msg\" : \"派单/报价->无锡市新吴区苏南硕放国际机场-T2航站楼\",\"order\" : {\"bookDays\":1,\"bookTime\":\"2020-05-28 09:00:00\",\"carLevel\":1,\"carNo\":\"苏Q35665\",\"driverNo\":\"257aa43e3e834ea0bd\",\"endAddr\":\"江苏省无锡市无锡市\",\"endLat\":31.49881,\"endLon\":120.318582,\"orderAmount\":100,\"orderModel\":1,\"orderNo\":\"202005261527502956\",\"orderStatus\":1,\"orderType\":1,\"orgId\":\"ffcf2166b02642e4bf\",\"passengerMobile\":\"15696164096\",\"passengerName\":\"岳不群\",\"payAmount\":0,\"planMileage\":15966,\"source\":9,\"startAddr\":\"无锡市新吴区苏南硕放国际机场-T2航站楼\",\"startLat\":31.510936,\"startLon\":120.440382,\"usrId\":0},\"taskId\" : \"2020052715114728386\",\"pushType\" : \"10000\"}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);

        payload.addCustomMsg("body", jsonObject);

        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("【任行约车】温馨提醒：您有新的订单啦，用车时间为:2020-05-28 09:00,上车地点为:无锡市新吴区苏南硕放国际机场-T2航站楼,目的地:江苏省无锡市无锡市，请您尽快处理,感谢您的支持和配合！"));
//        payload.setAlertMsg(getDictionaryAlertMsg());  //字典模式使用APNPayload.DictionaryAlertMsg

        //设置语音播报类型，int类型，0.不可用 1.播放body 2.播放自定义文本
        payload.setVoicePlayType(2);
        //设置语音播报内容，String类型，非必须参数，用户自定义播放内容，仅在voicePlayMessage=2时生效
        //注：当"定义类型"=2, "定义内容"为空时则忽略不播放
        payload.setVoicePlayMessage("【任行约车】温馨提醒：您有新的订单啦，用车时间为:2020-05-28 09:00,上车地点为:无锡市新吴区苏南硕放国际机场-T2航站楼,目的地:江苏省无锡市无锡市，请您尽快处理,感谢您的支持和配合！");

        // 添加多媒体资源
        payload.addMultiMedia(new MultiMedia().setResType(MultiMedia.MediaType.pic)
                .setResUrl("资源文件地址")
                .setOnlyWifi(true));

        return payload;
    }

    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg() {
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setBody("您有新的订单啦");
        alertMsg.setActionLocKey("显示关闭和查看两个按钮的消息");
        alertMsg.setLocKey("{\"title\" : \"任行出行\",\"msg\" : \"派单/报价->无锡市新吴区苏南硕放国际机场-T2航站楼\",\"order\" : {\"bookDays\":1,\"bookTime\":\"2020-05-28 09:00:00\",\"carLevel\":1,\"carNo\":\"苏Q35665\",\"driverNo\":\"257aa43e3e834ea0bd\",\"endAddr\":\"江苏省无锡市无锡市\",\"endLat\":31.49881,\"endLon\":120.318582,\"orderAmount\":100,\"orderModel\":1,\"orderNo\":\"202005261527502956\",\"orderStatus\":1,\"orderType\":1,\"orgId\":\"ffcf2166b02642e4bf\",\"passengerMobile\":\"15696164096\",\"passengerName\":\"岳不群\",\"payAmount\":0,\"planMileage\":15966,\"source\":9,\"startAddr\":\"无锡市新吴区苏南硕放国际机场-T2航站楼\",\"startLat\":31.510936,\"startLon\":120.440382,\"usrId\":0},\"taskId\" : \"2020052715114728386\",\"pushType\" : \"10000\"}");
        alertMsg.addLocArg("loc-ary1");
        alertMsg.setLaunchImage("调用已经在应用程序中绑定的图形文件名");
        // iOS8.2以上版本支持
        alertMsg.setTitle("【任行约车】");
        alertMsg.setTitleLocKey("温馨提醒：您有新的订单啦");
        alertMsg.addTitleLocArg("时间为:2020-05-28 09:00,订单号:202005261527502956,航班号:无,订单类型:接机,车型:经济型,上车地点为:无锡市新吴区苏南硕放国际机场-T2航站楼,目的地:江苏省无锡市无锡市,客户:岳不群,客户手机号:15696164096,请您尽快处理,感谢您的支持和配合！");
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
