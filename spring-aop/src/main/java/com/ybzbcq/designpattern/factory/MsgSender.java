package com.ybzbcq.designpattern.factory;

/**
 * 短信 发送 服务
 */

public class MsgSender implements Sender {
    @Override
    public void send() {
        System.out.println(" short msg sent ...");
    }
}
