package com.ybzbcq.designpattern.factory;

public class SendStaticFactory {

    /**
     * 邮件发送
     * @return
     */
    public static Sender emailProduce(){
        return new EmailSender();
    }

    /**
     * 短信发送
     * @return
     */
    public static Sender msgProduce(){
        return new MsgSender();
    }
}
