package com.ybzbcq.designpattern.command;

public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String command) {
        receiver.action(command);
    }
}
