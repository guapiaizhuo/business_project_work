package com.ActivitySignUp.service;

import com.ActivitySignUp.model.ActivityJoinStatus;
import com.ActivitySignUp.model.SignUpResponse;
import com.baomidou.mybatisplus.extension.service.IService;

public interface JoinActivity extends IService<SignUpResponse> {
    public ActivityJoinStatus joinActivity(Long activityId, Long userId);
    public boolean isReRoll(Long activityId, Long userId);
}
