package com.ybzbcq.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Administrator
 * @Description 读写锁 测试  ReentrantReadWriteLock  读写锁 jvm内置缓存
 * @since 2019-12-17 16:08
 */

class Cache {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();
    public  Map<String, Object> map = new HashMap<String, Object>();


    public Object get(String key) {
        Object result = null;
        r.lock();
        try {

            System.out.println("正在进行读操作， [key:]" + key + " 开始");
            Thread.sleep(100);
            result = map.get(key);
            System.out.println("正在进行读操作， [key:]" + key + " 结束");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }
        return result;
    }

    public Object put(String key, Object value) {

        Object result = null;
        w.lock();
        try {

            System.out.println("正在进程写操作， [key:]" + key + "[value:]" + value + " 开始");
            Thread.sleep(100);
            result = map.put(key, value);
            System.out.println("正在进程写操作， [key:]" + key + "[value:]" + value + " 结束");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }
        return result;
    }

    public void clear() {
        try {
            w.lock();
            map.clear();
        } finally {
            w.unlock();
        }
    }
}

public class Test3 {

    public static void main(String[] args) {
        final Cache cache = new Cache();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    cache.put(i + "", i + "");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(cache.get(i + ""));
                }

            }
        });

        t2.setPriority(Thread.MAX_PRIORITY);//设置最大的线程优先级
        //t2.setPriority(Thread.MIN_PRIORITY);//设置最小的线程优先级
        t2.start();
        t1.start();





    }
}