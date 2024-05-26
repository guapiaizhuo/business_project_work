package com.login.service.imp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.login.mapper.AdministratorMapper;
import com.login.model.AdministratorLogin;
import com.login.model.LOGINRESPONSE;
import org.springframework.stereotype.Service;

@Service
public class AdministratorImpl extends ServiceImpl<AdministratorMapper, AdministratorLogin> implements com.login.service.AdministratorLogin {
    @Override
    public LOGINRESPONSE administratorLogin(String id, String password){
        QueryWrapper<AdministratorLogin> qw = new QueryWrapper<>();
        qw.eq("id",id);
        AdministratorLogin login = getOne(qw);
        return login.getPassword().equals(password)?LOGINRESPONSE.SUCCESS:LOGINRESPONSE.FAULT;
    }
}
