package com.zsw.common.service;


import com.zsw.common.model.entity.Order;

import java.util.List;


public interface InnerOrderService {
    /**
     * 获取前 limit 购买数量的接口
     * @param limit
     * @return
     */
    List<Order> listTopBuyInterfaceInfo(int limit);
}
