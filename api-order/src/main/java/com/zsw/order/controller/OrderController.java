package com.zsw.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsw.common.common.BaseResponse;
import com.zsw.common.common.ResultUtils;
import com.zsw.common.model.dto.order.OrderAddRequest;
import com.zsw.common.model.dto.order.OrderQueryRequest;
import com.zsw.common.model.vo.OrderVO;
import com.zsw.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/addOrder")
    public BaseResponse<OrderVO> addOrder(@RequestBody OrderAddRequest addOrderRequest, HttpServletRequest request) {
        OrderVO orderVO = orderService.addOrder(addOrderRequest, request);
        return ResultUtils.success(orderVO);
    }

    @GetMapping("/list")
    public BaseResponse<Page<OrderVO>> listPageOrder(OrderQueryRequest orderQueryRequest, HttpServletRequest request){
        Page<OrderVO> orderPage = orderService.listPageOrder(orderQueryRequest, request);
        return ResultUtils.success(orderPage);
    }
}
