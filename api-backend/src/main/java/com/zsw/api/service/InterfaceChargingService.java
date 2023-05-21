package com.zsw.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.common.model.dto.UnLockAvailablePiecesDTO;
import com.zsw.common.model.entity.InterfaceCharging;

/**
* @description 针对表【interface_charging】的数据库操作Service
*/
public interface InterfaceChargingService extends IService<InterfaceCharging> {

    /**
     * 检查某个接口的库存是否充足
     * @param id
     * @return
     */
    boolean checkInventory(Long id);

    /**
     * 解锁库存
     * @param unLockAvailablePiecesDTO
     * @return
     */
    boolean unLockAvailablePieces(UnLockAvailablePiecesDTO unLockAvailablePiecesDTO);
}
