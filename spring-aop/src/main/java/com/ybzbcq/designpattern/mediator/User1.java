package com.ybzbcq.designpattern.mediator;

public class User1 extends AbstractUser {

    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println(" user1 executed ");
    }
}
