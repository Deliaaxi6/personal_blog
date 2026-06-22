package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.AlbumImage;
import com.boke.blog.mapper.AlbumImageMapper;
import com.boke.blog.service.AlbumImageService;
import org.springframework.stereotype.Service;

@Service
public class AlbumImageServiceImpl extends ServiceImpl<AlbumImageMapper, AlbumImage> implements AlbumImageService {
}
