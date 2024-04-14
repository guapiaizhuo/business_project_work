package com.commentSection.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("activity_comment")
public class Comment {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("activity_id")
    private Long activityId;
    @TableField("user_id")
    private Long userId;
    private String context;
}
