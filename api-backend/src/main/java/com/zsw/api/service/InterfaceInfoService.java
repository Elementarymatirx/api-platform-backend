package com.zsw.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.common.model.entity.InterfaceInfo;

/**
* 接口信息服务
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 上线接口
     * @param id
     * @return
     */
    Boolean onlineInterfaceInfo(long id);

    /**
     * 下线接口
     * @param id
     * @return
     */
    Boolean offlineInterfaceInfo(long id);
}
