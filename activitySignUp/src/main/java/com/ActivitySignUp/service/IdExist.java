package com.ActivitySignUp.service;

import com.ActivitySignUp.model.IdResponse;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IdExist extends IService<IdResponse> {
    public boolean isIdExist(Long activityId);
}
