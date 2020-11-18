package com.jade.config;

import com.jade.common.ElectionMaster;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private  ZkClient zkClient = new ZkClient("127.0.0.1:2181");

    private String path = "/election";

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("项目启动成功");
        createEphemeral();

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("开始重新选举 ...");
                createEphemeral();
            }
        });


    }

    /**
     * 创建临时节点
     */
    private void createEphemeral() {
        try {
            zkClient.createEphemeral(path);
            System.out.println("server port:" + serverPort+", 选举成功 ... ");
            ElectionMaster.isSurvival = true;
        } catch (RuntimeException e) {
            ElectionMaster.isSurvival = false;
            System.out.println(path + ", 该节点已经存在");
        }
    }


}
