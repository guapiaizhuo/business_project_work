package com.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.login.model.Login;
import com.login.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper extends BaseMapper<UserLogin>{

}