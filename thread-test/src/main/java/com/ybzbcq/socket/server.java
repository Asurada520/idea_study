package com.ybzbcq.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {

        try {
            // 创建 socketServer 监听端口 8080
            ServerSocket server = new ServerSocket(8080);
            // 等待请求
            Socket socket = server.accept();
            // 接收到请求后，使用socket进行通信，创建 BufferedReader 用于读取数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader is = new BufferedReader(new InputStreamReader(inputStream));
            String line = is.readLine();
            System.out.println("received from client: " + line);

            // 创建 printWriter 使用发送数据
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("received data: " + line);

            // 关闭资源
            printWriter.flush();
            printWriter.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
