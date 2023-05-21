package com.zsw.thirdparty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsw.common.model.entity.AlipayInfo;
import com.zsw.thirdparty.mapper.AlipayInfoMapper;
import com.zsw.thirdparty.service.AlipayInfoService;
import org.springframework.stereotype.Service;

/**
* @description 针对表【alipay_info】的数据库操作Service实现
*/
@Service
public class AlipayInfoServiceImpl extends ServiceImpl<AlipayInfoMapper, AlipayInfo>
    implements AlipayInfoService {

}




