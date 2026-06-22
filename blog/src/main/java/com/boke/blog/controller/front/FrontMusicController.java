package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Music;
import com.boke.blog.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台音乐公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/music")
public class FrontMusicController {

    private final MusicService musicService;

    /** 查询音乐列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Music>> list() {
        return ApiResponse.success(musicService.list(new LambdaQueryWrapper<Music>().eq(Music::getStatus, 1).orderByAsc(Music::getSort).orderByDesc(Music::getCreateTime)));
    }
}

