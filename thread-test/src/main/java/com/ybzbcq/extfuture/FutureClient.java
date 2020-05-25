package com.ybzbcq.extfuture;

/**
 * @author Administrator
 * @Description 客户端
 * @since 2019-12-17 14:44
 */

public class FutureClient {

    public Data request(final String reqStr){
        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(reqStr);
                futureData.setRequest(realData);
            }
        }).start();

        return futureData;
    }

}