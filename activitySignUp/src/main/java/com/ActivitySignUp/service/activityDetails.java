package com.ActivitySignUp.service;

import com.ActivitySignUp.model.IdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "AliyunUpload-service")
public interface activityDetails {
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public IdResponse upload(@RequestParam("id")String id);
}

