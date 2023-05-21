package com.zsw.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsw.common.model.entity.Order;

import java.util.List;

/**
* @description 针对表【order】的数据库操作Mapper
*/
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 获取前 limit 购买数量的接口
     * @param limit
     * @return
     */
    List<Order> listTopBuyInterfaceInfo(int limit);

}




