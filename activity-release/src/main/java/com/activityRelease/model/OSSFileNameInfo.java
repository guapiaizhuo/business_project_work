package com.activityRelease.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("oss_file_name")
public class OSSFileNameInfo  {
    @TableId(value = "uid",type= IdType.AUTO)
    private Long uid;
    private Long id;
    @TableField("activity_name")
    private String name;
    @TableField("picture_url")
    private String pictureUrl;

}
