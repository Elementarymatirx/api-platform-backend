package com.zsw.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.common.model.dto.UpdateUserInterfaceInfoDTO;
import com.zsw.common.model.entity.UserInterfaceInfo;
import com.zsw.common.model.vo.UserInterfaceInfoVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户接口关系服务
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add 是否为创建校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用次数 + 1
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId) ;

    /**
     * 更新用户接口信息
     * @param updateUserInterfaceInfoDTO
     * @return
     */
    boolean updateUserInterfaceInfo(UpdateUserInterfaceInfoDTO updateUserInterfaceInfoDTO);

    /**
     * 检验用户是否有调用次数
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    boolean checkUserInvokeAuth(Long userId, Long interfaceInfoId);

    /**
     * 根据Id获取某个用户拥有的接口信息
     * @param userId
     * @param request
     * @return
     */
    List<UserInterfaceInfoVO> getInterfaceInfoByUserId(Long userId, HttpServletRequest request);
}
