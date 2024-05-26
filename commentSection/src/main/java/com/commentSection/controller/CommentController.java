package com.commentSection.controller;

import com.commentSection.model.Comment;
import com.commentSection.model.CommitCommentStatus;
import com.commentSection.model.Likes;
import com.commentSection.service.CommitComment;
import com.commentSection.service.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommitComment commitCommentImpl;
    @Autowired
    Like likeImpl;

    @RequestMapping("/index")
    public String index(){
        return "test";
    }

    @RequestMapping("/commit")
    public ResponseEntity<String> commit(@RequestParam("comment") String comment,
                                         @RequestParam("activityId") Long activityId,
                                         @RequestParam("userId") Long userId) {
        CommitCommentStatus status = commitCommentImpl.commit(activityId,userId,comment);
        if (status == CommitCommentStatus.SUCCESS) {
            return ResponseEntity.ok().body("评论成功成功");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status.getMessage());
    }

    @RequestMapping("/getComment")
    @ResponseBody
    public List<Comment> getComment(@RequestParam Long currentPage,
                                    @RequestParam String id){
        return commitCommentImpl.selectPage(currentPage,id);
    }
    @RequestMapping("/getLikes")
    @ResponseBody
    public Map<String,Object> getLikes(@RequestParam Long id){
        return likeImpl.findLikes(id);
    }
}
