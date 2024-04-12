package com.ActivitySignUp.service.imp;

import com.ActivitySignUp.mapper.IdResponseMapper;
import com.ActivitySignUp.model.IdResponse;
import com.ActivitySignUp.service.IdExist;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdExistImp extends ServiceImpl<IdResponseMapper, IdResponse> implements IdExist {
    public boolean isIdExist(Long activityId){
        QueryWrapper<IdResponse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", activityId); // "username" 是表中的字段名
        return this.count(queryWrapper) > 0;
    }
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public boolean isJoin(Long activityId,Long studentId){
//        //检查id是否存在报名人数是否小于参与人数
//        if (isIdExist(activityId)){
//            //插入数据活动表操作
//
//
//            return true;
//        }
//        else
//            return false;
//    }

}
