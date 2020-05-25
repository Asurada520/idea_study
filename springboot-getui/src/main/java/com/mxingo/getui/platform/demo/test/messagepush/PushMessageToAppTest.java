package com.mxingo.getui.platform.demo.test.messagepush;

import com.gexin.rp.sdk.base.IIGtPush;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;

import java.util.ArrayList;
import java.util.List;

public class PushMessageToAppTest extends PushBase{
    public static void main(String[] args) {

        // 推送主类
        IIGtPush push = new IGtPush(API, APPKEY, MASTERSECRET);

        try {

            AppMessage message = new AppMessage();

            //通知模版：支持TransmissionTemplate、LinkTemplate、NotificationTemplate，此处以LinkTemplate为例
            //在通知栏显示一条含图标、标题等的通知，用户点击可打开您指定的网页
            LinkTemplate template = new LinkTemplate();

            template.setAppId(APPID);								//应用APPID
            template.setAppkey(APPKEY);							//应用APPKEY

            //通知属性设置：如通知的标题，内容
            template.setTitle("填写通知标题");						// 通知标题
            template.setText("填写通知内容");					// 通知内容
            template.setLogo("hello.png");
//			template.setIsRing(true);					// 收到通知是否响铃，可选，默认响铃
//			template.setIsVibrate(true);					// 收到通知是否震动，可选，默认振动
//			template.setIsClearable(true);				// 通知是否可清除，可选，默认可清除
            template.setUrl("http://baidu.com");		//点击通知后打开的网页地址，你可以设定你希望跳转的网页地址如http://www.igetui.com

            message.setData(template);
//			message.setOffline(true);		//用户当前不在线时，是否离线存储，可选，默认不存储
//			message.setOfflineExpireTime(72 * 3600 * 1000);		//离线有效时间，单位为毫秒，可选

            List<String> appIdList = new ArrayList<String>();
            appIdList.add(APPID);

            List<String> phoneTypeList = new ArrayList<String>();//通知接收者的手机操作系统类型，可选
            phoneTypeList.add("ANDROID");

            List<String> provinceList = new ArrayList<String>();		//通知接收者所在省份，可选
            provinceList.add("江苏");
            provinceList.add("上海");
            provinceList.add("北京");

            List<String> tagList = new ArrayList<String>();			//通知接收者的标签用户，可选
            tagList.add("填写tags名称");

            message.setAppIdList(appIdList);
            message.setPhoneTypeList(phoneTypeList);
            message.setProvinceList(provinceList);
            message.setTagList(tagList);

            IPushResult ret = push.pushMessageToApp(message);

            System.out.println(ret.getResponse().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
