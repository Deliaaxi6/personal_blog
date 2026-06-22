package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.Album;
import com.boke.blog.mapper.AlbumMapper;
import com.boke.blog.service.AlbumService;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {
}
