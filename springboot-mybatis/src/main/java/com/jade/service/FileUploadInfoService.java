package com.jade.service;

import com.jade.dao.FileUploadInfoMapper;
import com.jade.entity.FileUploadInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUploadInfoService {

    @Autowired
    private FileUploadInfoMapper fileUploadInfoMapper;


    public List<FileUploadInfoEntity> getInfo(){
        return fileUploadInfoMapper.getInfo();
    }
}
