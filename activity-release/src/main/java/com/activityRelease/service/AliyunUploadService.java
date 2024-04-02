package com.activityRelease.service;

import com.activityRelease.config.ActivityConf;
import com.activityRelease.model.OSSResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "AliyunUpload-service", configuration = ActivityConf.class)
public interface AliyunUploadService {
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OSSResult upload(@RequestPart("file") MultipartFile uploadFile,@RequestParam("id")String id);
}
