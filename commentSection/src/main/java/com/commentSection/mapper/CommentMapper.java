package com.commentSection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.commentSection.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
