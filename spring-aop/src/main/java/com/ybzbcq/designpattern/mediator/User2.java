package com.ybzbcq.designpattern.mediator;

public class User2 extends AbstractUser {

    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println(" user2 executed ");
    }
}
