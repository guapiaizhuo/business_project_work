package com.ActivitySignUp.service.imp;

import com.ActivitySignUp.mapper.SignUpResponseMapper;
import com.ActivitySignUp.model.ActivityJoinStatus;
import com.ActivitySignUp.model.IdResponse;
import com.ActivitySignUp.model.SignUpResponse;
import com.ActivitySignUp.service.IdExist;
import com.ActivitySignUp.service.JoinActivity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;

@Service
public class JoinActivityImp extends ServiceImpl<SignUpResponseMapper, SignUpResponse> implements JoinActivity {
    @Autowired
    public IdExist idExistImp;
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean isFull(Long activity_id) {
        QueryWrapper<SignUpResponse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("activity_id", activity_id);
        QueryWrapper<IdResponse> qw = new QueryWrapper<>();
        qw.eq("id", activity_id);
        int limit = idExistImp.getOne(qw).getNumberOfParticipants();
        long count = this.count(queryWrapper);
        System.out.println("limit:"+limit+"count:"+count);
        return count <= limit;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ActivityJoinStatus joinActivity(Long activityId, Long userId) {
        if (idExistImp.isIdExist(activityId)) {
            SignUpResponse signUp = new SignUpResponse();
            signUp.setActivity_id(activityId);
            signUp.setUser_id(userId);
            this.save(signUp);
            try {
                if (!isFull(activityId))
                    throw new RuntimeException("超出报名人数");
                return ActivityJoinStatus.SUCCESS;
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                System.out.println(e);
                return ActivityJoinStatus.ACTIVITY_FULL;
            }
        }
        return ActivityJoinStatus.ACTIVITY_NOT_FOUND;
    }

    @Override
    public boolean isReRoll(Long activityId, Long userId) {
        if (!this.isFull(activityId)){
            LocalDateTime stamp = this.getOne(new QueryWrapper<SignUpResponse>().eq("user_id",userId)).getTimestamp();
            QueryWrapper<SignUpResponse> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("activity_id",activityId).le("timestamp",stamp);
            QueryWrapper<IdResponse> qw = new QueryWrapper<>();
            qw.eq("id", activityId);
            if (this.count(queryWrapper)>idExistImp.getOne(qw).getNumberOfParticipants()){
                this.remove(new QueryWrapper<SignUpResponse>().eq("activity_id",activityId).eq("user_id",userId));
                System.out.println("移除已报名");
                return true;
            }
        }
        return false;
    }

}
