package com.ybzbcq.designpattern.mediator;

public abstract class AbstractUser {
    private Mediator mediator;

    public AbstractUser(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator(){
        return mediator;
    }

    public abstract void work();


}
