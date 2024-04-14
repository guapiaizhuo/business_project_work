package com.commentSection.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.commentSection.model.SignUpResponse;

public interface JoinActivity extends IService<SignUpResponse> {
    public boolean isExistUserId(Long activityId, Long userId);
}
