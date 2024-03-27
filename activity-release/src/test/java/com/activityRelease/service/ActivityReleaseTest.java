package com.activityRelease.service;

import com.activityRelease.mapper.ActivityMapper;
import com.activityRelease.model.ActivityInfo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityReleaseTest {
    @Resource
    private ActivityMapper activityInfoMapper;

    @Test
    void  testSave(){
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setId(1L);
        activityInfo.setDescription("wgjy");
        activityInfo.setLocation("mj");
        activityInfo.setName("aaaa");
        activityInfo.setPublisher("sss");
        activityInfo.setTime("0-1");
        activityInfo.setNumberOfParticipants(5);
        activityInfoMapper.insert(activityInfo);
    }
}