package com.activityRelease.service.Imp;

import com.activityRelease.controller.activityController;
import com.activityRelease.mapper.ActivityMapper;
import com.activityRelease.model.ActivityInfo;
import com.activityRelease.model.OSSFileNameInfo;
import com.activityRelease.model.OSSResult;
import com.activityRelease.service.ActivityRelease;
import com.activityRelease.service.AliyunUploadService;
import com.activityRelease.service.PicturesUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityReleaseImp extends ServiceImpl<ActivityMapper, ActivityInfo> implements ActivityRelease {
    @Autowired
    private PicturesUrlService picturesUrlService;
    @Autowired
    private AliyunUploadService aliyunUploadService;

    @Transactional
    @Override
    public void addActivities(ActivityInfo activityInfo, List<MultipartFile> files) {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : files) {
            filenames.add(file.getOriginalFilename());
        }
        save(activityInfo);
        try {
            //        调用AliyunUpload-service
            //        OSSResult OSSUpload = restTemplate.getForObject("http://AliyunUpload-service/file/upload", OSSResult.class);
            for (MultipartFile multipartFile:files) {
                OSSFileNameInfo ossFileNameInfo = new OSSFileNameInfo();
                OSSResult ossResult = aliyunUploadService.upload(multipartFile);
                ossFileNameInfo.setId(activityInfo.getId());
                System.out.println(ossFileNameInfo.getId());
                ossFileNameInfo.setPictureUrl(ossResult.getUrl());
                System.out.println(ossFileNameInfo.getPictureUrl());
                ossFileNameInfo.setName(activityInfo.getName());
                System.out.println(ossFileNameInfo.getName());
                //保存图片url表
                picturesUrlService.save(ossFileNameInfo);
            }

        }
        catch (Exception E){
            throw new RuntimeException();
        }
    }
}
