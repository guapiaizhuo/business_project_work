package com.activityRelease.service.Imp;

import com.activityRelease.mapper.ActivityMapper;
import com.activityRelease.model.ActivityInfo;
import com.activityRelease.service.ActivityRelease;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityReleaseImp extends ServiceImpl<ActivityMapper, ActivityInfo> implements ActivityRelease {
    @Autowired
    private ActivityMapper activityInfoMapper;
}
