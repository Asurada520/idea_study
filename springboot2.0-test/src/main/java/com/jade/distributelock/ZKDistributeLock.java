package com.jade.distributelock;

import org.I0Itec.zkclient.ContentWatcher;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class ZKDistributeLock extends ZKAbstractLock {

    /**
     * 获取锁
     *
     * @return 是否获取成功
     */
    @Override
    protected boolean tryLock() {
        boolean flag = false;
        try {
            zkClient.createEphemeral(path);
            flag = true;
        } catch (Exception e) {
//            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 事件监听
     */
    @Override
    protected void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String path) throws Exception {
                // System.out.println("zkDataListener the path: " + path);
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }

            }
        };

        zkClient.subscribeDataChanges(path, iZkDataListener);

        if (zkClient.exists(path)) {
            // zkClient.exists(lockPath)
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(path, iZkDataListener);

    }


}
