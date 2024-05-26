package com.commentSection.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment_like")
public class Likes {
    private Long id;
    private int likes;
}
