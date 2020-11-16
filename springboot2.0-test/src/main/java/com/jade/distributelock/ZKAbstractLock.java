package com.jade.distributelock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public abstract class ZKAbstractLock implements ExtLock {


    protected ZkClient zkClient = new ZkClient("localhost:2181");

    // 创建临时节点路径
    protected  String path = "/lock";

    protected CountDownLatch countDownLatch = new CountDownLatch(1);


    @Override
    public void getLock() {

        // 获取连接
        if(tryLock()){
            System.out.println("Getting lock is successful.");
        }else{
            // 如果没有获取成功则等待
            waitLock();
            getLock();
        }



    }

    protected abstract void waitLock();

    protected abstract boolean tryLock();

    @Override
    public void unLock() {
        if (zkClient != null){
            zkClient.close();
            System.out.println("zookeeper connection is closed.");
        }

    }
}
