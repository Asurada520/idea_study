package com.ybzbcq.service;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class ZKService {

    @Value("${connection}")
    private String connection;

    public String createNode(String path){
        try {
//            ZkClient zkClient = new ZkClient("localhost:2186,localhost:2187,localhost:2188");
            ZkClient zkClient = new ZkClient(connection);
            zkClient.createPersistent(path);
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
}
