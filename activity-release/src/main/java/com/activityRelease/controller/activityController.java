package com.activityRelease.controller;

import com.activityRelease.model.ActivityInfo;
import com.activityRelease.service.ActivityRelease;
import com.alibaba.cloud.commons.lang.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/activity")
public class activityController {
    @Autowired
    ActivityRelease activityRelease;
    @RequestMapping("/index")
    public String index() {
        // 转发到 /static/aaa.html，根据Spring Boot的默认配置，静态资源位于 /static 目录下
        // 这里不需要写出完整路径，Spring Boot会自动寻找static目录下的资源
        return "你好";
    }

    @RequestMapping("/createActivity")
    @ResponseBody
    public String createActivity(@RequestBody ActivityRequest activityRequest) {
//         验证数据是否为空
        if (StringUtils.isEmpty(activityRequest.getName()) ||
                StringUtils.isEmpty(activityRequest.getDescription()) ||
                StringUtils.isEmpty(activityRequest.getPublisher()) ||
                activityRequest.getNumberOfParticipants() == 0 ||
                StringUtils.isEmpty(activityRequest.getTime()) ||
                StringUtils.isEmpty(activityRequest.getLocation())) {
            return "活动异常";
        }

//         数据转换为实体类
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setName(activityRequest.getName());
        activityInfo.setDescription(activityRequest.getDescription());
        activityInfo.setPublisher(activityRequest.getPublisher());
        activityInfo.setNumberOfParticipants(activityRequest.getNumberOfParticipants());
        activityInfo.setTime(activityRequest.getTime());
        activityInfo.setLocation(activityRequest.getLocation());

        System.out.println(activityInfo);

//         存入数据库
        activityRelease.save(activityInfo);

        return "活动创建成功";
    }

    @Data
    public static class ActivityRequest {
        private String name; // 活动名
        private String description; // 活动描述
        private String publisher; // 活动发布者
        private int numberOfParticipants; // 活动人数
        private String time; // 活动时间
        private String location; // 活动地点

        // 构造函数、getter和setter省略，需要根据实际情况补充

        @Override
        public String toString() {
            return "ActivityRequest{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", numberOfParticipants=" + numberOfParticipants +
                    ", time='" + time + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }

    }
}
