package com.ybzbcq.designpattern.abstractfactory;

public class MsgFactry implements Provider{
    @Override
    public Sender produce() {
        return new MsgSender();
    }
}
