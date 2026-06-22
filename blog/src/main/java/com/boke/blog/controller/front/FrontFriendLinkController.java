package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.FriendLink;
import com.boke.blog.service.FriendLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台友链公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/friend")
public class FrontFriendLinkController {

    private final FriendLinkService friendLinkService;

    /** 查询友链列表。 */
    @GetMapping("/list")
    public ApiResponse<List<FriendLink>> list() {
        return ApiResponse.success(friendLinkService.list(new LambdaQueryWrapper<FriendLink>().eq(FriendLink::getStatus, 1).orderByAsc(FriendLink::getSort).orderByDesc(FriendLink::getCreateTime)));
    }
}

