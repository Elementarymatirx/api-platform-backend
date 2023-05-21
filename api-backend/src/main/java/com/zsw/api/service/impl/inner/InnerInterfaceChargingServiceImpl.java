package com.zsw.api.service.impl.inner;

import com.zsw.api.service.InterfaceChargingService;
import com.zsw.common.common.ErrorCode;
import com.zsw.common.exception.BusinessException;
import com.zsw.common.model.dto.UnLockAvailablePiecesDTO;
import com.zsw.common.model.dto.UpdateAvailablePiecesDTO;
import com.zsw.common.model.entity.InterfaceCharging;
import com.zsw.common.service.InnerInterfaceChargingService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;


@DubboService
public class InnerInterfaceChargingServiceImpl implements InnerInterfaceChargingService {
    @Resource
    InterfaceChargingService interfaceChargingService;

    @Override
    public boolean checkInventory(Long id) {
        return interfaceChargingService.checkInventory(id);
    }

    @Override
    public boolean updateAvailablePieces(UpdateAvailablePiecesDTO updateAvailablePiecesDTO) {
        Long chargingId = updateAvailablePiecesDTO.getChargingId();
        Long count = updateAvailablePiecesDTO.getCount();
        if (null == chargingId || null == count || count < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        InterfaceCharging interfaceCharging = interfaceChargingService.getById(chargingId);
        if (interfaceCharging == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        String availablePieces = interfaceCharging.getAvailablePieces();
        long b = Long.parseLong(availablePieces) - count;
        if (b < 0) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "库存不足");
        }

        InterfaceCharging updateInterfaceCharging = new InterfaceCharging();
        updateInterfaceCharging.setId(chargingId);
        updateInterfaceCharging.setAvailablePieces(String.valueOf(b));
        boolean update = interfaceChargingService.updateById(updateInterfaceCharging);
        return update;
    }

    @Override
    public boolean unLockAvailablePieces(UnLockAvailablePiecesDTO unLockAvailablePiecesDTO) {
        return interfaceChargingService.unLockAvailablePieces(unLockAvailablePiecesDTO);
    }
}
