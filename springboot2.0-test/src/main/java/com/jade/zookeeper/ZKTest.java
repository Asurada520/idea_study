package com.jade.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.Ids;

import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZKTest {

    // 连接地址
    private static String CONNECTIONADDRESS = "127.0.0.1:2181";
    // 超时时间
    private static int SESSIONTIMEOUT = 2000;
    // java 并发包 信号量技术 控制zk连接成功后，开始创建节点，否则就会等待
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //创建连接
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTIONADDRESS, SESSIONTIMEOUT, new Watcher() {

            // 事件的回调方法
            @Override
            public void process(WatchedEvent event) {
                // 获取事件状态
                KeeperState keeperState = event.getState();
                // 获取时间类型
                EventType eventType = event.getType();
                // 判断是否已经连接
                if (KeeperState.SyncConnected == keeperState) {
                    // 客户端与服务端成功建立连接
                    if (EventType.None == eventType) {
                        countDownLatch.countDown();
                        System.out.println("connection successful");
                    }
                }
            }
        });
        countDownLatch.await();


        String nodeName = "/test002/t4";

        // 判断 Node 状态
        Stat exists = zooKeeper.exists(nodeName, true);
        System.out.println("--->"+exists);

        if(exists != null){
            System.out.println("Node 节点已经存在，节点名称：" + nodeName);
        }else{
            // 参数说明： key, value, 权限【任何人都可以操作，不需要验证】, 节点类型
            String nodeResult = zooKeeper.create(nodeName, "listing23".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("nodeResult: " + nodeResult);
        }

        // 关闭连接
        zooKeeper.close();

    }


}
