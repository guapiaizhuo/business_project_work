package com.commentSection.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.commentSection.model.Comment;
import com.commentSection.model.CommitCommentStatus;

import java.util.List;

public interface CommitComment extends IService<Comment> {
    CommitCommentStatus commit(Long activityId, Long userId, String context);
    List<Comment> selectPage(Long currentPage, String input);
}
