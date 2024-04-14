package com.commentSection.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.commentSection.model.Comment;
import com.commentSection.model.CommitCommentStatus;

public interface CommitComment extends IService<Comment> {
    CommitCommentStatus commit(Long activityId, Long userId, String context);
}
