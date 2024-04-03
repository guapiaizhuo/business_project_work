package com.ActivityDetails.controller;

import com.ActivityDetails.model.ActivityInfo;
import com.ActivityDetails.model.PictureResponse;
import com.ActivityDetails.service.GetActivityNameList;
import com.ActivityDetails.service.GetPictureUrl;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/activity")
public class ActivityDetailsController {
    @Autowired
    GetActivityNameList getActivityNameList;
    @Autowired
    GetPictureUrl getPictureUrl;

    @RequestMapping("/searchName")
    @ResponseBody
    public List<ActivityInfo> searchName(@RequestParam("name")String name) {
        if (!StringUtils.isBlank(name)){
            List<ActivityInfo>activityInfoList = getActivityNameList.getActivityNameList(name);
            return activityInfoList;
        }
        else
            return null;
    }

    @RequestMapping("/showDetails")
    @ResponseBody
    public List<PictureResponse> showDetails(@RequestParam("id")Long id) {
        if (!StringUtils.isBlank(id.toString())){
            List<PictureResponse>activityInfoList = getPictureUrl.getPictureResponse(id);
            return activityInfoList;
        }
        else
            return null;
    }

}
