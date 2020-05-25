package com.ybzbcq.designpattern.factory;

public class Test {
    public static void main(String[] args) {

//        普通工厂模式
//        SendFactory sendFactory = new SendFactory();
//        Sender mail = sendFactory.produce("mail");
//        mail.send();

//        工厂方法模式
//        Sender sender = sendFactory.msgProduce();
//        sender.send();

//        静态工厂方法
        Sender senderStatic = SendStaticFactory.emailProduce();
        senderStatic.send();

    }
}
