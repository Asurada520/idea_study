package com.ybzbcq.designpattern.abstractfactory;

import com.ybzbcq.designpattern.abstractfactory.Sender;

/**
 * 短信 发送 服务
 */

public class MsgSender implements Sender {
    @Override
    public void send() {
        System.out.println(" 短信已经发送 ...");
    }
}
