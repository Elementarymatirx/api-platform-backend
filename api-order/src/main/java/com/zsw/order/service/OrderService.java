package com.zsw.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.common.model.dto.order.OrderAddRequest;
import com.zsw.common.model.dto.order.OrderQueryRequest;
import com.zsw.common.model.entity.Order;
import com.zsw.common.model.vo.OrderVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @description 针对表【order】的数据库操作Service
*/
public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     * @param addOrderRequest
     * @return
     */
    OrderVO addOrder(OrderAddRequest addOrderRequest, HttpServletRequest request);

    /**
     * 获取订单列表
     * @param orderQueryRequest
     * @param request
     * @return
     */
    Page<OrderVO> listPageOrder(OrderQueryRequest orderQueryRequest, HttpServletRequest request);

    /**
     * 获取前 limit 购买数量的接口
     * @param limit
     * @return
     */
    List<Order> listTopBuyInterfaceInfo(int limit);
}
