package com.ybzbcq.extfuture;

import javax.swing.*;

/**
 * @author Administrator
 * @Description 自定义Future模式  测试
 * @since 2019-12-17 14:48
 */

public class Test {
    public static void main(String[] args) {

        FutureClient futureClient = new FutureClient();
        Data request = futureClient.request("请求");

        System.out.println("请求发送成功 ... ");
        System.out.println("主程序执行其他任务 ...");

        String result = request.getRequest();

        System.out.println("获取到的结果是：" + result);

    }
}