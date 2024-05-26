package com.commentSection.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.commentSection.model.Likes;

import java.util.List;
import java.util.Map;

public interface Like extends IService<Likes> {
    Map<String,Object> findLikes(Long id);
}
