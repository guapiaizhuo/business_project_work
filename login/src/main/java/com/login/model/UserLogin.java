package com.login.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserLogin {
    private int id;
    private String password;
}
