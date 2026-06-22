package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.Music;
import com.boke.blog.mapper.MusicMapper;
import com.boke.blog.service.MusicService;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements MusicService {
}
