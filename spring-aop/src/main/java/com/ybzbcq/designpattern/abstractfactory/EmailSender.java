package com.ybzbcq.designpattern.abstractfactory;

import com.ybzbcq.designpattern.abstractfactory.Sender;

/**
 * 邮件发送 服务
 */
public class EmailSender implements Sender{
    @Override
    public void send() {
        System.out.println(" 邮件已经发送 ...");
    }
}
