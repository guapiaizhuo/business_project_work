package com.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.login.model.LOGINRESPONSE;

public interface UserLogin extends IService<com.login.model.UserLogin> {
    LOGINRESPONSE login(String id,String password);
}
