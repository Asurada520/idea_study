package com.ybzbcq.designpattern.abstractfactory;

public class EmailFactory implements Provider{

    @Override
    public Sender produce() {
        return new EmailSender();
    }
}
