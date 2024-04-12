package com.ActivitySignUp.controller;

import com.ActivitySignUp.model.ActivityJoinStatus;
import com.ActivitySignUp.service.JoinActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SignUp")
public class SignUpController {
    @Autowired
    JoinActivity joinActivityImp;

    @RequestMapping("/index")
    public String index(){
        return "test";
    }

    @CrossOrigin
    @RequestMapping("/joinActivity")
    @ResponseBody
    public ResponseEntity<String> joinActivity(@RequestParam("activityId")Long activityId, @RequestParam("userId")Long userId){
        ActivityJoinStatus status=joinActivityImp.joinActivity(activityId, userId);
        switch (status) {
            case SUCCESS->{
                if (joinActivityImp.isReRoll(activityId,userId))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("超出报名人数");
                return ResponseEntity.ok().body("报名成功");
            }
            case ACTIVITY_NOT_FOUND-> {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("无此活动");
            }
            case ACTIVITY_FULL-> {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("超出报名人数");
            }
            default-> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("其他错误");
            }
        }
    }
}
