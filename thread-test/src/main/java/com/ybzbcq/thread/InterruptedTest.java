package com.ybzbcq.thread;

public class InterruptedTest {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Work());
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

        System.out.println("Main thread stopped.");
        System.out.println(thread.activeCount());
        System.out.println(thread.currentThread());
//        thread.dumpStack();
        System.out.println("--------------------");
        Thread[] tarray = new Thread[20];
        int enumerate = thread.enumerate(tarray);
        System.out.println(enumerate);

        for (int i = 0; i <tarray.length ; i++) {
//            tarray[i].getName();
            if(tarray[i] == null){
                break;
            }
            System.out.println(tarray[i].toString());
            System.out.println(tarray[i].getName()+" 线程状态：" + tarray[i].getState()+" 所属线程组：" + tarray[i].getThreadGroup()+" 该线程的上下文classloader: "+tarray[i].getContextClassLoader());
        }

    }


    public static class Work implements Runnable{

        @Override
        public void run() {
            System.out.println("我在做一些事情。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread curr = Thread.currentThread();
                //再次调用interrupt方法中断自己，将中断状态设置为“中断”
//                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
//                System.out.println("-------------------------------------------------");
                curr.interrupt();
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Static Call: " + Thread.interrupted());//clear status
                System.out.println("---------After Interrupt Status Cleared----------");
                System.out.println("Static Call: " + Thread.interrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
                System.out.println("Worker IsInterrupted: " + curr.isInterrupted());
            }

            System.out.println("Worker stopped.");
        }
    }
}

