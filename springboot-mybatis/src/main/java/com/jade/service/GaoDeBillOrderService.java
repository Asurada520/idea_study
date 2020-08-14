package com.jade.service;

import com.jade.dao.GaoDeBillOrderMapper;
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

    public int batchInsert(List<Map> list) {

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
        new Thread(new Runnable() {
            @Override
            public void run() {

                String createtime = (String)(list.get(0).get("createtime"));

                // 查询是否存在数据 司机编号
                List<String> driverCodesList = new ArrayList<String>();


                for (int i = 0; i < list.size(); i++) {
                    Map m1 = list.get(i);
                    String drivercode1 = (String)m1.get("drivercode");

                    // 司机编号
                    if(!driverCodesList.contains(drivercode1)){
                        driverCodesList.add(drivercode1);
                    }

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
