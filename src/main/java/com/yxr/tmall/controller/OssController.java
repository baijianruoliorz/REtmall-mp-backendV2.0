package com.yxr.tmall.controller;

import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liqiqi_tql
 * @date 2020/8/17 -20:40
 */
@RestController
@RequestMapping("/tmall/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;
//    上传头像的方法
    @PostMapping
    public R uploadOssFile(MultipartFile file){
//        获取上传的文件 nultipartFile
//        返回上传的的oss路径
        String url=ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }

}
