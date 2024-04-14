package com.commentSection.controller;

import com.commentSection.model.CommitCommentStatus;
import com.commentSection.service.CommitComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommitComment commitCommentImpl;

    @RequestMapping("/index")
    public String index(){
        return "test";
    }

    @RequestMapping("commit")
    public ResponseEntity<String> commit(@RequestParam("comment") String comment,
                                         @RequestParam("activityId") Long activityId,
                                         @RequestParam("userId") Long userId) {
        CommitCommentStatus status = commitCommentImpl.commit(activityId,userId,comment);
        if (status == CommitCommentStatus.SUCCESS) {
            return ResponseEntity.ok().body("报名成功");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status.getMessage());
    }
}
