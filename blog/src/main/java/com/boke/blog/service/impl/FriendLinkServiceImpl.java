package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.FriendLink;
import com.boke.blog.mapper.FriendLinkMapper;
import com.boke.blog.service.FriendLinkService;
import org.springframework.stereotype.Service;

@Service
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper, FriendLink> implements FriendLinkService {
}
