package com.zsw.thirdparty.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    /**
     * 上传头像到OSS
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);

}
