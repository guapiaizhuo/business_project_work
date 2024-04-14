package com.commentSection.service.Imp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.commentSection.model.SignUpResponse;
import com.commentSection.service.JoinActivity;
import com.commentSection.mapper.SignUpResponseMapper;
import org.springframework.stereotype.Service;

@Service
public class JoinActivityImp extends ServiceImpl<SignUpResponseMapper, SignUpResponse> implements JoinActivity {
    @Override
    public boolean isExistUserId(Long activityId, Long userId) {
        QueryWrapper<SignUpResponse> qw = new QueryWrapper<>();
        qw.eq("activity_id",activityId).eq("user_id",userId);
        SignUpResponse findOne = this.getOne(qw);
        return findOne != null;
    }
}
