package com.zsw.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsw.api.mapper.InterfaceChargingMapper;
import com.zsw.api.service.InterfaceChargingService;
import com.zsw.common.common.ErrorCode;
import com.zsw.common.exception.BusinessException;
import com.zsw.common.model.dto.UnLockAvailablePiecesDTO;
import com.zsw.common.model.entity.InterfaceCharging;
import org.springframework.stereotype.Service;

@Service
public class InterfaceChargingServiceImpl extends ServiceImpl<InterfaceChargingMapper, InterfaceCharging>
        implements InterfaceChargingService {

    @Override
    public boolean checkInventory(Long id) {
        if(id == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceCharging interfaceCharging = this.getById(id);
        return Integer.parseInt(interfaceCharging.getAvailablePieces())>= 0;
    }

    @Override
    public boolean unLockAvailablePieces(UnLockAvailablePiecesDTO unLockAvailablePiecesDTO) {
        Long interfaceId = unLockAvailablePiecesDTO.getInterfaceId();
        Long count = unLockAvailablePiecesDTO.getCount();
        UpdateWrapper<InterfaceCharging> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceId", interfaceId).setSql("availablePieces = availablePieces + " + count);
        boolean update = this.update(updateWrapper);
        if(!update){
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return update;
    }
}
