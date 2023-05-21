package com.zsw.api.service.impl.inner;

import com.zsw.api.service.UserInterfaceInfoService;
import com.zsw.common.model.dto.UpdateUserInterfaceInfoDTO;
import com.zsw.common.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public boolean updateUserInterfaceInfo(UpdateUserInterfaceInfoDTO updateUserInterfaceInfoDTO) {
        return userInterfaceInfoService.updateUserInterfaceInfo(updateUserInterfaceInfoDTO);
    }

    @Override
    public boolean checkUserInvokeAuth(Long userId, Long interfaceId) {
        return userInterfaceInfoService.checkUserInvokeAuth(userId, interfaceId);
    }


}
