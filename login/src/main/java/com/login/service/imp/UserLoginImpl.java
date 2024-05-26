package com.login.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.login.mapper.UserLoginMapper;
import com.login.model.AdministratorLogin;
import com.login.model.LOGINRESPONSE;
import com.login.model.UserLogin;

import org.springframework.stereotype.Service;

@Service
public class UserLoginImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements com.login.service.UserLogin {
    @Override
    public LOGINRESPONSE login(String id, String password) {
        QueryWrapper<UserLogin> qw = new QueryWrapper<>();
        qw.eq("id",id);
        UserLogin login = getOne(qw);
        if (login==null)
            return LOGINRESPONSE.FAULT;
        return login.getPassword().equals(password)?LOGINRESPONSE.SUCCESS:LOGINRESPONSE.FAULT;
    }




}
