package com.jade.dao;

import com.jade.entity.IndentInfoEntity;

import java.util.List;

public interface IndentInfoMapper {

    List<IndentInfoEntity> selectAll();

    int insert(IndentInfoEntity indentInfo);
}
