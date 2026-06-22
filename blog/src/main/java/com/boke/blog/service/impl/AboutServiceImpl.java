package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.About;
import com.boke.blog.mapper.AboutMapper;
import com.boke.blog.service.AboutService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService {
}
