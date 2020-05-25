package com.ybzbcq.designpattern.factory;

/**
 * 邮件发送 服务
 */
public class EmailSender implements Sender{
    @Override
    public void send() {
        System.out.println(" E-mail sent ...");
    }
}
