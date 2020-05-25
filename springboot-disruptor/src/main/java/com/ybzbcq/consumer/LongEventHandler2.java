package com.ybzbcq.consumer;

import com.lmax.disruptor.EventHandler;
import com.ybzbcq.entity.LongEvent;

/**
 * 消费者 获取 生产者 推送数据
 */
public class LongEventHandler2 implements EventHandler<LongEvent> {

    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者 2 获取到的数据：" + longEvent.getValue());
    }
}
