package com.jade.dao;

import java.util.List;
import java.util.Map;

public interface DriverMapper {

    public List<Map> getDriver();

    public int batchInsertList(List<Map> list);
}
