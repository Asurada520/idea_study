package com.ybzbcq.designpattern.command;

public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(String commandMes){
        command.execute(commandMes);
    }
}
