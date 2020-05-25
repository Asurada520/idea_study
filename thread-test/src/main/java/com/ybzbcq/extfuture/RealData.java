package com.ybzbcq.extfuture;

/**
 * @author Administrator
 * @Description 真实数据
 * @since 2019-12-17 14:31
 */

public class RealData extends Data {

    private String result;

    public RealData(String data) {

        System.out.println("正在使用data:" + data + "网络请求的数据，是耗时操作，需要等待 ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕，获取结果 ... ");
        this.result = "黄大仙";
    }

    @Override
    public String getRequest() {
        return result;
    }
}