package com.zsw.order.service.impl;

import com.zsw.common.model.entity.Order;
import com.zsw.common.service.InnerOrderService;
import com.zsw.order.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;


@DubboService
public class InnerOrderServiceImpl implements InnerOrderService {
    @Resource
    OrderService orderService;
    @Override
    public List<Order> listTopBuyInterfaceInfo(int limit) {
        return orderService.listTopBuyInterfaceInfo(limit);
    }
}
