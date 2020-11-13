package com.jade.zookeeper;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ZKClientSocket {

    public static List<String> listServer = new ArrayList<String>();

    private static String parent = "/test";

    public static void main(String[] args) {

        initServer();
        // console  input
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        ZKClientSocket client = new ZKClientSocket();

        while (true) {
            System.out.println("请输入您的信息：");
            String name = null;

            try {

                name = console.readLine();
                if ("exit".equals(name)) {
                    System.exit(0);
                }
                client.send(name);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    // 请求次数
    private static int reqestCount = 1;
    // 服务数量
    private static int serverCount = 0;

    // 注册所有server
    public static void initServer() {
//        listServer.clear();
//        listServer.add("127.0.0.1:18080");

        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 6000, 1000);
        List<String> children = zkClient.getChildren(parent);

        getChildren(zkClient, children);
        // 监听事件
        zkClient.subscribeChildChanges(parent, new IZkChildListener() {

            public void handleChildChange(String parentPath, List<String> currentChildren) throws Exception {
                getChildren(zkClient, currentChildren);
            }
        });
    }

    private static void getChildren(ZkClient zkClient, List<String> currentChildren) {
        listServer.clear();
        for (String p : currentChildren) {
            String pathValue = (String) zkClient.readData(parent + "/" + p);
            listServer.add(pathValue);
        }
        serverCount = listServer.size();
        System.out.println("从zk读取到信息:" + listServer.toString());

    }

    // 获取当前server信息
    public static String getServer() {
//        return listServer.get(0);

        // 实现负载均衡
        String serverName = listServer.get(reqestCount % serverCount);
        ++reqestCount;
        return serverName;

    }


    public void send(String name) {

        String server = getServer();
        String[] cfg = server.split(":");

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(cfg[0], Integer.parseInt(cfg[1]));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(name);
            while (true) {
                String resp = in.readLine();
                if (resp == null)
                    break;
                else if (resp.length() > 0) {
                    System.out.println("Receive : " + resp);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
