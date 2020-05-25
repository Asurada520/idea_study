package com.ybzbcq.thread2;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @Description callable
 * @since 2019-12-16 11:09
 */


class TaskCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("正在执行任务，需要等待五秒时间，执行任务开始");
        Thread.sleep(5000);
        System.out.println("正在执行任务，需要等待五秒时间，执行任务结束");
        return "你大爷答应我了";
    }

}

public class ThreadTest004 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new TaskCallable());


        System.out.println("主线程任务开始执行 ... ");
        Thread.sleep(2000);

        String result = future.get();

        System.out.println("[Result <-- ]" + result);

        if(executorService != null){
            executorService.shutdown();
        }
        System.out.println("主线程任务结束执行 ... ");

    }

}