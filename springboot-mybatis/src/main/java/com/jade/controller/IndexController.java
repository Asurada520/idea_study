package com.jade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/go/")
public class IndexController {

    @RequestMapping("batch")
    public String goBatch(){
        return "batch";
    }


    /**
     * 下载导入模版
     * @param request
     * @param response
     * @return
     */
    @GetMapping("download")
    @ResponseBody
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {

        String fileType = request.getParameter("fileType");
        System.out.println("fileType:" + fileType);


        String fileName = null;// 订单模版

        if("1".equals(fileType)){
            fileName = "driver.xlsx"; // 司机模版
        } else if("2".equals(fileType)){
            fileName = "order.xlsx"; // 司机模版
        }

        if (fileName != null) {
            //设置文件路径
            File file = new File("D:/download/"+fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}

