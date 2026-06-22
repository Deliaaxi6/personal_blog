package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.Talk;
import com.boke.blog.mapper.TalkMapper;
import com.boke.blog.service.TalkService;
import org.springframework.stereotype.Service;

@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {
}
