package com.commentSection.model;

public enum CommitCommentStatus {
    SUCCESS("评论提交成功"),
    OVER_COMMIT("超过最大提交数"),
    USER_NOTFOUND("用户未参加活动"),
    OTHER_ERROR("其他错误");

    private final String message;


    CommitCommentStatus(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
