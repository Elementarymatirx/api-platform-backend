package com.zsw.thirdparty.service.impl;

import com.zsw.common.service.InnerOssService;
import com.zsw.thirdparty.service.OssService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@DubboService
public class InnerOssServiceImpl implements InnerOssService {
    @Resource
    OssService ossService;
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        return ossService.uploadFileAvatar(file);
    }
}
