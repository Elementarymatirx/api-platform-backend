package com.zsw.common.model.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class UpdateAvailablePiecesDTO implements Serializable {
    private static final long serialVersionUID = 1354230288973784689L;

    /**
     * 计费ID
     */
    private Long chargingId;

    /**
     * 锁定次数
     */
    private Long count;
}
