/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alibaba.mos.service;

import com.alibaba.mos.api.ItemService;
import com.alibaba.mos.data.ItemDO;
import com.alibaba.mos.data.SkuDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author superchao
 * @version $Id: ItemServiceImpl.java, v 0.1 2019年10月28日 11:11 AM superchao Exp $
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<ItemDO> aggregationSkus(List<SkuDO> skuList) {
        //TODO 在此实现聚合sku的代码
        return null;
    }
}