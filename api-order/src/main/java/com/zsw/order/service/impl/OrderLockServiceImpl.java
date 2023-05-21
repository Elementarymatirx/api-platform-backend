package com.zsw.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsw.common.model.entity.OrderLock;
import com.zsw.order.mapper.OrderLockMapper;
import com.zsw.order.service.OrderLockService;
import org.springframework.stereotype.Service;

/**
* @description 针对表【order_lock】的数据库操作Service实现
*/
@Service
public class OrderLockServiceImpl extends ServiceImpl<OrderLockMapper, OrderLock>
        implements OrderLockService {

}




