package com.zsw.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsw.api.mapper.InterfaceInfoMapper;
import com.zsw.api.service.InterfaceInfoService;
import com.zsw.common.common.ErrorCode;
import com.zsw.common.exception.BusinessException;
import com.zsw.common.model.entity.InterfaceInfo;
import com.zsw.common.model.enums.InterfaceInfoStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 接口信息服务实现类
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name,url) ) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
    }

    @Override
    public Boolean onlineInterfaceInfo(long id) {
        InterfaceInfo oldInterfaceInfo = this.getById(id);
        if(oldInterfaceInfo == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"该接口不存在");
        }
        //todo 测试接口是否可以使用 这里为模拟 先调用clint的接口模拟一下
        //将接口状态设为 1
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        interfaceInfo.setStatus(InterfaceInfoStatusEnum.ONLINE.getValue());
        boolean update = this.updateById(interfaceInfo);
        return update;
    }

    @Override
    public Boolean offlineInterfaceInfo(long id) {
        InterfaceInfo oldInterfaceInfo = this.getById(id);
        if(oldInterfaceInfo == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"该接口不存在");
        }

        //将接口状态设为 0
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        interfaceInfo.setStatus(InterfaceInfoStatusEnum.OFFLINE.getValue());
        boolean update = this.updateById(interfaceInfo);
        return update;
    }
}
