package com.ActivitySignUp.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("activity_signup")
public class SignUpResponse {
    private Long activity_id;
    private Long user_id;
    private LocalDateTime timestamp;
}
