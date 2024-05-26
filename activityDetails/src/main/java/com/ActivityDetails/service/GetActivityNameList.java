package com.ActivityDetails.service;

import com.ActivityDetails.model.ActivityInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface GetActivityNameList extends IService<ActivityInfo> {
    List<ActivityInfo> getActivityNameList(String name);
    List<ActivityInfo> getPage(long age);
}
