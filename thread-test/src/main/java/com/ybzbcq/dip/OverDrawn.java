package com.ybzbcq.dip;

public class OverDrawn extends AccountStatus {
    @Override
    public void sendCorrespondence() {
        System.out.println("Account is overDrawn");
    }
}
