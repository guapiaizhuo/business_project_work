package com.ActivityDetails.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("activities")
public class ActivityInfo {
    private Long id;
    @TableField("activity_name")
    private String name;
    private String description;
    private String publisher;
    @TableField("numberOfParticipants")
    private int numberOfParticipants;
    private String time;
    private String location;
}
