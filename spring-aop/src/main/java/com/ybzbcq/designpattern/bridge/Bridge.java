package com.ybzbcq.designpattern.bridge;

public abstract class Bridge {

    private Sourceable sourceable;
/*
    public Bridge() {
    }

    public Bridge(Sourceable sourceable) {
        this.sourceable = sourceable;
    }*/

    public Sourceable getSourceable(){
        return sourceable;
    }

    public void setSourceable(Sourceable sourceable){
        this.sourceable = sourceable;
    }

    public void method(){
        sourceable.method();
    }


}
