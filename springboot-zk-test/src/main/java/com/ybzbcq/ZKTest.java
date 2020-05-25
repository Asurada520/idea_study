package com.ybzbcq;

import com.ybzbcq.service.ZKService;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;

public class ZKTest {

    @Autowired
    private static ZKService zkService = new ZKService();
    public static void main(String[] args) {

       /* String connection = "localhost:2186,localhost:2187,localhost:2188";
        ZkClient zkClient = new ZkClient(connection);
        zkClient.createPersistent("/jade");
        zkClient.close();*/
        zkService.createNode("/jade");

    }
}
