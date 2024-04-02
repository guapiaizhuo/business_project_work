package com.activityRelease.service;

import com.activityRelease.controller.activityController;
import com.activityRelease.model.ActivityInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ActivityRelease extends IService<ActivityInfo> {
    void addActivities(ActivityInfo activityInfo, List<MultipartFile> files);
}
