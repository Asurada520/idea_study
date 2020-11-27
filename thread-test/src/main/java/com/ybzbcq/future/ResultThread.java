package com.ybzbcq.future;

import java.util.concurrent.*;

public class ResultThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        Future future = executor.submit(new ResultCallable());

        System.out.println(Thread.currentThread().getName()+", 线程正在执行其他任务");

        Object result = future.get();

        System.out.println("Future模式 获取结果：" + result);

        if(executor != null){
            executor.shutdown();
        }


    }

}


class ResultCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("Callable class 工程测试");
        Thread.sleep(1000);
        return "1000";
    }
}
