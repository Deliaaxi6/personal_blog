package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Talk;
import com.boke.blog.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台说说公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/talk")
public class FrontTalkController {

    private final TalkService talkService;

    /** 查询说说列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Talk>> list() {
        return ApiResponse.success(talkService.list(new LambdaQueryWrapper<Talk>().eq(Talk::getStatus, 1).orderByDesc(Talk::getCreateTime)));
    }
}
