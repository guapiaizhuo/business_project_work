package com.login.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("authority")
public class AdministratorLogin extends Login{
    private String authority;
}
