package com.zsw.common.service;

import org.springframework.web.multipart.MultipartFile;

public interface InnerOssService {
    /**
     * 上传头像到 Oss
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
