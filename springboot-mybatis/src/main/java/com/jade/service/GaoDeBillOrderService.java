package com.jade.service;

import com.jade.dao.GaoDeBillOrderMapper;
import com.jade.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GaoDeBillOrderService {

    @Autowired
    private GaoDeBillOrderMapper gaoDeBillOrderMapper;

    public int batchInsert(List<Map> list, String time) {

        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }

        int sum = gaoDeBillOrderMapper.batchInsertList(list);

        /**
         * 处理数据
         * 1.当前日期  日 yyyy-MM-dd  月 yyyy-MM
         * 2.计算数据
         * 3.获取所有相关司机的数据【司机编号】
         *     无 新增 【批量新增】
         *     有 相加后，更新【批量更新】
         */
        // 获取两个时间
        String shortDateFormat = DateUtil.getShortDateFormat(time);
        String monthFormat = DateUtil.getMonthFormat(time);

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 查询是否存在天数据 司机编号+年月日
                List<String> driverCodesShortList = new ArrayList<String>();
                // 查询是否存在天数据 司机编号+年月
                List<String> driverCodesMonthList = new ArrayList<String>();


                for (int i = 0; i < list.size(); i++) {

                    Map m1 = list.get(i);
                    String drivercode1 = (String)m1.get("drivercode");

                    // 日表查询条件 司机编码+yyyy-MM-dd
                    String shortDate = drivercode1.concat(shortDateFormat);
                    if(!driverCodesShortList.contains(shortDate)){
                        driverCodesShortList.add(shortDate);
                    }
                    // 月表表查询条件 司机编码+yyyy-MM
                    String monthDate = drivercode1.concat(monthFormat);
                    if(!driverCodesMonthList.contains(monthDate)){
                        driverCodesMonthList.add(monthDate);
                    }

                    String actualmileage1 = (String)m1.get("actualmileage"); // 实际里程
                    String actualtime1 = (String)m1.get("actualtime"); // 实际时长
                    String surcharge1 = (String)m1.get("surcharge"); // 附加费
                    String mileageprice1 = (String)m1.get("mileageprice"); // 里程费



                    for (int j = list.size() - 1; j > i; j--) {
                        Map m2 = list.get(j);
                        String drivercode2 = (String)m2.get("drivercode");
                        if (drivercode1.equals(drivercode2)) {

                            /**
                             * date	日期  日 yyyy-MM-dd, 月 yyyy-MM
                             * drivingtime 出车时长
                             * servicetime 服务时长
                             * drivercancelcount 司机取消量
                             * complaintcount 投诉量
                             */


                            list.remove(j);
                        }
                    }
                }

            }
        }).start();


        return sum;
    }
}
