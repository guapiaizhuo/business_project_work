package com.ActivityDetails.controller;

import com.ActivityDetails.model.ActivityInfo;
import com.ActivityDetails.model.ActivityResponse;
import com.ActivityDetails.model.PictureResponse;
import com.ActivityDetails.service.GetActivityNameList;
import com.ActivityDetails.service.GetPictureUrl;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/activity")
public class ActivityDetailsController {
    @Autowired
    GetActivityNameList getActivityNameList;
    @Autowired
    GetPictureUrl getPictureUrl;

    @RequestMapping("/index")
    public String index(){
        return "activities-search";
    }

    @RequestMapping("/searchName")
    @ResponseBody
    public List<ActivityResponse> searchName(@RequestParam("name")String name) {
        if (!StringUtils.isBlank(name)){
            List<ActivityInfo>activityInfoList = getActivityNameList.getActivityNameList(name);
            List<ActivityResponse> activityResponseList = new ArrayList<>();
            for (ActivityInfo activityInfo:activityInfoList){
                ActivityResponse activityResponse = new ActivityResponse();
                activityResponse.setId(activityInfo.getId().toString());
                activityResponse.setName(activityInfo.getName());
                activityResponse.setDescription(activityInfo.getDescription());
                activityResponse.setLocation(activityInfo.getLocation());
                activityResponse.setPublisher(activityInfo.getPublisher());
                activityResponse.setTime(activityInfo.getTime());
                activityResponse.setNumberOfParticipants(activityInfo.getNumberOfParticipants());
                activityResponseList.add(activityResponse);
            }
            return activityResponseList;
        }
        else
            return null;
    }

    @RequestMapping("/showDetails")
    @ResponseBody
    public List<PictureResponse> showDetails(@RequestParam("id")Long id) {
        if (!StringUtils.isBlank(id.toString())){
            System.out.println(id);
            List<PictureResponse>activityInfoList = getPictureUrl.getPictureResponse(id);
            for (PictureResponse p:activityInfoList)
                System.out.println(p.getPictureUrl());
            return activityInfoList;
        }
        else
            return null;
    }

    @RequestMapping("/showPage")
    @ResponseBody
    public List<ActivityInfo> showPage(@RequestParam long page){
        return getActivityNameList.getPage(page);
    }

    @RequestMapping("/show")
    public String show(){
        return "activity-show";
    }

}
