package com.zsw.common.model.dto.order;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


@Data
public class OrderAddRequest {

    /**
     * 接口id
     */
    private Long interfaceId;

    /**
     * 计费Id
     */
    private Long chargingId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 购买数量
     */
    private Long count;

    /**
     * 单价
     */
    private Double charging;

    /**
     * 交易金额
     */
    private Double totalAmount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
