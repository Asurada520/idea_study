package com.ybzbcq.factory;

import com.lmax.disruptor.EventFactory;
import com.ybzbcq.entity.LongEvent;

/**
 * 需要让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象。
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }
}
