package com.zsw.common.service;


import com.zsw.common.model.entity.InterfaceInfo;

public interface InnerInterfaceInfoService {

    /**
     * 获取调用的接口信息
     * @param url
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String url, String method);

    /**
     * 根据ID获取接口信息
     * @param id
     * @return
     */
    InterfaceInfo getInterfaceInfoById(Long id);

}
