package com.zsw.common.model.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class UnLockAvailablePiecesDTO implements Serializable {
    private static final long serialVersionUID = 1354230288973784689L;

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * 锁定次数
     */
    private Long count;
}
