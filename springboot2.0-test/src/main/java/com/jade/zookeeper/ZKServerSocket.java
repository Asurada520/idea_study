package com.jade.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import java.net.ServerSocket;
import java.net.Socket;

public class ZKServerSocket implements Runnable {

    private static int port = 18082;

    public ZKServerSocket(int port) {
        this.port = port;
    }

    public static void main(String[] args) {

        ZKServerSocket zkServerSocket = new ZKServerSocket(port);
        Thread thread = new Thread(zkServerSocket);
        thread.start();
    }

    // 注册服务
    public void registerServer() {

        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 6000, 1000);

        // 创建临时节点
        String nodePath = "/test/server_" + port;
        if (zkClient.exists(nodePath)) {
            zkClient.delete(nodePath);
        }

        zkClient.createEphemeral(nodePath, "127.0.0.1:" + port);
    }


    @Override
    public void run() {

        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(port);

            //注册服务
            registerServer();

            System.out.println("Server start port:" + port);

            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
