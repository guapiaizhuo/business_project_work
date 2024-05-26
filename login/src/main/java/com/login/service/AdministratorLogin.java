package com.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.login.model.LOGINRESPONSE;

public interface AdministratorLogin extends IService<com.login.model.AdministratorLogin> {
    public LOGINRESPONSE administratorLogin(String id, String password);
}
