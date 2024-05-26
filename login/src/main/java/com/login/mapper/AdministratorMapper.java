package com.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.login.model.AdministratorLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorMapper extends BaseMapper<AdministratorLogin> {
}
