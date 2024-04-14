package com.commentSection.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.commentSection.model.Comment;
import com.commentSection.model.CommitCommentStatus;
import com.commentSection.service.CommitComment;
import com.commentSection.service.JoinActivity;
import com.commentSection.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommitCommentImp extends ServiceImpl<CommentMapper, Comment> implements CommitComment {
    @Autowired
    JoinActivity joinActivityImpl;

    public CommitCommentStatus isAllowCommit(Long activityId, Long userId) {
        QueryWrapper<Comment> countQW = new QueryWrapper<>();
        countQW.eq("activity_id", activityId);
        countQW.eq("user_id", userId);
        long count = this.count(countQW);
        if (count > 10)
            return CommitCommentStatus.OVER_COMMIT;
        else if (!joinActivityImpl.isExistUserId(activityId, userId))
            return CommitCommentStatus.USER_NOTFOUND;
        else
            return CommitCommentStatus.SUCCESS;
    }

    public CommitCommentStatus commit(Long activityId, Long userId, String context) {
        Comment comment = new Comment();
        comment.setActivityId(activityId);
        comment.setUserId(userId);
        comment.setContext(context);
        if (isAllowCommit(activityId, userId) == CommitCommentStatus.SUCCESS) {
            this.save(comment);
            return CommitCommentStatus.SUCCESS;
        }
        return CommitCommentStatus.OVER_COMMIT;
    }
}
