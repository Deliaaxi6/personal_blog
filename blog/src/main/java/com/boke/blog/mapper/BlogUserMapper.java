package com.boke.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boke.blog.entity.BlogUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogUserMapper extends BaseMapper<BlogUser> {
}
