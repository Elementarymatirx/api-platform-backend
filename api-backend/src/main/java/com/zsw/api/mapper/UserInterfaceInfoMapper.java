package com.zsw.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsw.common.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




