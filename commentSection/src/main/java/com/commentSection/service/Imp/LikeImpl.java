package com.commentSection.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.commentSection.mapper.LikesMapper;
import com.commentSection.model.Likes;
import com.commentSection.service.Like;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LikeImpl extends ServiceImpl<LikesMapper, Likes> implements Like {
    @Override
    public Map<String,Object> findLikes(Long id) {
        QueryWrapper<Likes> qw = new QueryWrapper<>();
        qw.eq("id",id);
        return getMap(qw);
    }
}
