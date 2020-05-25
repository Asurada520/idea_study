package com.ybzbcq.designpattern.factory;

/**
 *  信息发送工厂类
 */
public class SendFactory {
    public Sender produce(String type){
        if("mail".equals(type)){
            return new EmailSender();
        }else if("msg".equals(type)){
            return new MsgSender();
        }else{
            System.out.println("please input a correct type, thank you.");
            return null;
        }
    }

    /**
     * 邮件发送
     * @return
     */
    public Sender emailProduce(){
        return new EmailSender();
    }

    /**
     * 短信发送
     * @return
     */
    public Sender msgProduce(){
        return new MsgSender();
    }

}
