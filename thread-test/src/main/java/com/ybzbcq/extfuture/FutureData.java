package com.ybzbcq.extfuture;

/**
 * @author Administrator
 * @Description
 *              FutureData,当有线程想要获取RealData的时候，程序会被阻塞。
 *              等到RealData被注入才会使用getReal()方法。
 * @since 2019-12-17 14:30
 */

public class FutureData extends Data {


    public volatile boolean isFlag = false;

    private RealData realData;

    public synchronized void setRequest(RealData realData){

        if(isFlag){
            return ;
        }
        this.realData =  realData;
        isFlag = true;
        notify();
    }


    @Override
    public synchronized String getRequest() {

        while (!isFlag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getRequest();
    }
}