package com.ybzbcq.producer;

import com.lmax.disruptor.RingBuffer;
import com.ybzbcq.entity.LongEvent;

import java.nio.ByteBuffer;

public class LongEventProducer {

    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer){


        long data = byteBuffer.getLong(0);
        long sequence = ringBuffer.next();

        try {
            LongEvent longEvent = ringBuffer.get(sequence);
            longEvent.setValue(data);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }finally {
            System.out.println("生产者 发送数据 ... ");
            ringBuffer.publish(sequence);
        }






    }
}
