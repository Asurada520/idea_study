package com.ybzbcq.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.ybzbcq.enums.FileType;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/extFileUpload/")
public class ExtFileUploadController {


    @RequestMapping("goUI")
    public String goUpFile(Model model) {
        return "extFileUpload";
    }


    @RequestMapping("upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file) {

        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4GFdwKqJqk2D29yni5KJ";
        String accessKeySecret = "lPgTlfKR6RKvOEoPK7Xg5WNR6QHeZv";
        String bucketName = "ljwximg";

        try {

            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            System.out.println("ossClient: " + ossClient);

            String fileName= file.getOriginalFilename();
            System.out.println("FileName:" + fileName);
            InputStream inputStream = file.getInputStream();
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, inputStream);
            System.out.println("putObjectResult:" + putObjectResult);

            return "success";
        } catch (Exception e) {
            System.out.println("e:" + e);
            return "failure";
        }


    }

    // 判断文件是图片格式
    public static FileType getFileType(InputStream is) throws IOException {
        byte[] src = new byte[28];
        is.read(src, 0, 28);
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }

        System.out.println("文件属性代码:" + Arrays.toString(src));

        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v).toUpperCase();
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        FileType[] fileTypes = FileType.values();
        for (FileType fileType : fileTypes) {
            if (stringBuilder.toString().startsWith(fileType.getValue())) {
                return fileType;
            }
        }
        return null;
    }
}
