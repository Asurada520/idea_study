package com.ybzbcq;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.ybzbcq.consumer.LongEventHandler;
import com.ybzbcq.consumer.LongEventHandler2;
import com.ybzbcq.entity.LongEvent;
import com.ybzbcq.factory.LongEventFactory;
import com.ybzbcq.producer.LongEventProducer;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
//        线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        LongEventFactory eventFactory = new LongEventFactory();

        int ringBufferSize = 1024 * 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, ringBufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.handleEventsWith(new LongEventHandler2());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        // 9.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 10; i++) {
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }
        //10.关闭disruptor和executor
        disruptor.shutdown();
        executor.shutdown();

    }
}
