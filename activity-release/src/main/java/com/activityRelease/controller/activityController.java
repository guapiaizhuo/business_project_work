package com.activityRelease.controller;

import com.activityRelease.model.ActivityInfo;
import com.activityRelease.service.ActivityRelease;
import com.alibaba.cloud.commons.lang.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/activity")
public class activityController {
    @Autowired
    ActivityRelease activityRelease;
    @RequestMapping("/face")
    public String index() {
        // 转发到 /static/aaa.html，根据Spring Boot的默认配置，静态资源位于 /static 目录下
        // 这里不需要写出完整路径，Spring Boot会自动寻找static目录下的资源
        return "wall";
    }

    @RequestMapping("/createActivity")
    @ResponseBody
    public String createActivity(@RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("publisher") String publisher,
                                 @RequestParam("numberOfParticipants") int numberOfParticipants,
                                 @RequestParam("time") String time,
                                 @RequestParam("location") String location,
                                 @RequestParam("files") List<MultipartFile> files) {
//         验证数据是否为空
        if (StringUtils.isEmpty(name) ||
                StringUtils.isEmpty(description) ||
                StringUtils.isEmpty(publisher) ||
                numberOfParticipants == 0 ||
                StringUtils.isEmpty(time) ||
                StringUtils.isEmpty(location)) {
            return "活动异常";
        }

//         数据转换为实体类
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setName(name);
        activityInfo.setDescription(description);
        activityInfo.setPublisher(publisher);
        activityInfo.setNumberOfParticipants(numberOfParticipants);
        activityInfo.setTime(time);
        activityInfo.setLocation(location);


        System.out.println(activityInfo);

//         存入数据库
        try {
            activityRelease.addActivities(activityInfo,files);
        }
        catch (Exception e){
            return "活动创建失败/n"+e;
        }

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
        private List<MultipartFile> files;


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
