package com.boke.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boke.blog.entity.Talk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TalkMapper extends BaseMapper<Talk> {
}
