package com.ybzbcq.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) {

        String msg = "Client data";
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // send msg
            printWriter.println(msg);
            printWriter.flush();
            // received data
            String line = is.readLine();
            System.out.println("received data from server: " + line);

            // 关闭资源
            printWriter.close();
            is.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
