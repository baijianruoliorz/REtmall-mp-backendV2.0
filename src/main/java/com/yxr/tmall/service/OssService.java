package com.yxr.tmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liqiqi_tql
 * @date 2020/8/17 -20:40
 */
public interface OssService {

    //上传头像到OSS
    String uploadFileAvatar(MultipartFile file);
}
