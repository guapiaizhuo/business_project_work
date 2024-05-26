package com.ActivityDetails.service.Imp;

import com.ActivityDetails.mapper.ActivityNameMapper;
import com.ActivityDetails.model.ActivityInfo;
import com.ActivityDetails.service.GetActivityNameList;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GetActivityNameListImp extends ServiceImpl<ActivityNameMapper, ActivityInfo> implements GetActivityNameList {
    @Autowired
    ActivityNameMapper activityNameMapper;
    @Override
    public List<ActivityInfo> getActivityNameList(String name) {
        List<ActivityInfo> list;
        LambdaQueryWrapper<ActivityInfo> qw = new LambdaQueryWrapper<>();
        qw.like(ActivityInfo::getName,name);
        list = list(qw);
        return list;
    }

    @Override
    public List<ActivityInfo> getPage(long currentPage) {
        QueryWrapper<ActivityInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().orderByDesc("time");
        Page<ActivityInfo> page = new Page<>(currentPage,5);
        IPage<ActivityInfo> iPage = activityNameMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }
}
