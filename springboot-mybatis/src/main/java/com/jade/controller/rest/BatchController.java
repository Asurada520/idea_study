package com.jade.controller.rest;


import com.jade.dao.GaoDeBillOrderMapper;
import com.jade.service.DriverService;
import com.jade.service.GaoDeBillOrderService;
import com.jade.utils.DateUtil;
import com.jade.utils.ExcelUtil;
import com.jade.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/batch/")
@Slf4j
public class BatchController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private GaoDeBillOrderService gaoDeBillOrderService;

    @RequestMapping("driver")
    public Object batch(){
        List<Map> driverList = driverService.getDriver();
        return driverList;
    }


    @RequestMapping(value = "wxDriverInfo", method = RequestMethod.POST)
    public Object getExcelData(MultipartFile filename) {
        List<List<Object>> readDriverlists = new ArrayList<>();
        try {
            readDriverlists = ExcelUtil.getUserListByExcel(filename.getInputStream(), filename.getOriginalFilename());
            List<Map> driverInsertList = new ArrayList<>();
            //
            for (int i = 0; i < readDriverlists.size(); i++) {
                Map order = new HashMap();
                List<Object> object = readDriverlists.get(i);
                order.put("cuuid",UuidUtil.get18UUID());
                order.put("ccode",object.get(0).toString());
                order.put("ccity",object.get(1).toString());
                order.put("ccityname",object.get(2).toString());
                order.put("linetype",object.get(3).toString());
                order.put("surname",object.get(4).toString());
                order.put("name",object.get(5).toString());
                order.put("fullname",object.get(6).toString());
                order.put("identify",object.get(7).toString());
                order.put("phone",object.get(8).toString());
                order.put("driveridentify",object.get(9).toString());
                order.put("drivertype",object.get(10).toString());
                order.put("licenseprovince",object.get(11).toString());
                order.put("licenseno",object.get(12).toString());
                order.put("fulllicense",object.get(13).toString());
                order.put("carbrand",object.get(14).toString());
                order.put("cartype",object.get(15).toString());
                order.put("carlevel",object.get(16).toString());
                order.put("carcolor",object.get(17).toString());
                order.put("seats",object.get(18).toString());
                order.put("energytype",object.get(19).toString());
                order.put("recommend",object.get(20).toString());
                order.put("recommendcode",object.get(21).toString());
                order.put("status",object.get(22).toString());
                order.put("createtime",object.get(23).toString());
                order.put("updatetime",object.get(24).toString());
                driverInsertList.add(order);

            }
            System.out.println("list: "+driverInsertList);
            //插入数据
           driverService.batchInsert(driverInsertList);




        } catch (Exception e) {
            e.printStackTrace();
        }

        return readDriverlists;
    }

    /**
     * 高德订单
     * @param filename 导入文件
     * @return
     */
    @RequestMapping(value = "gaoDeBillOrder", method = RequestMethod.POST)
    public Object batchGaoDeBillOrder(MultipartFile filename) {
        List<List<Object>> readFilelists = new ArrayList<>();
        try {
            readFilelists = ExcelUtil.getUserListByExcel(filename.getInputStream(), filename.getOriginalFilename());
            //List<List<Object>>--->List<User>
            List<Map> orderInsertList = new ArrayList<>();
            String dateTime = DateUtil.formatDateTime();
            //
            for (int i = 0; i < readFilelists.size(); i++) {
                Map order = new HashMap();
                List<Object> object = readFilelists.get(i);
                order.put("cuuid",UuidUtil.get18UUID());
                order.put("billcode",object.get(0).toString());
                order.put("drivercode",object.get(1).toString());
                order.put("drivername",object.get(2).toString());
                order.put("fleetname",object.get(3).toString());
                order.put("phone",object.get(4).toString());
                order.put("plateno",object.get(5).toString());
                order.put("carbrand",object.get(6).toString());
                order.put("cartype",object.get(7).toString());
                order.put("cityname",object.get(8).toString());
                order.put("actualmileage",object.get(9).toString());
                order.put("actualtime",object.get(10).toString());
                order.put("surcharge",object.get(11).toString());
                order.put("mileageprice",object.get(12).toString());
                order.put("totalprice",object.get(13).toString());
                order.put("createtime",dateTime);
                orderInsertList.add(order);
            }
            System.out.println("orderInsertList: "+orderInsertList);
            //插入数据
            gaoDeBillOrderService.batchInsert(orderInsertList, dateTime);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return readFilelists;
    }

}
