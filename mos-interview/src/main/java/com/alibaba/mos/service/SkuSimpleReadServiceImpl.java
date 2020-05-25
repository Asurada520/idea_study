/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alibaba.mos.service;

import com.alibaba.mos.api.SkuSimpleReadService;
import com.alibaba.mos.data.SkuDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author superchao
 * @version $Id: SkuSimpleReadServiceImpl.java, v 0.1 2019年10月28日 11:54 AM superchao Exp $
 */
@Service
public class SkuSimpleReadServiceImpl implements SkuSimpleReadService {

    @Override
    public List<SkuDO> loadSkus() {
        //TODO 在此实现从resource文件excel中加载sku的代码
        return null;
    }
}