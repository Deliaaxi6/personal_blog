package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Album;
import com.boke.blog.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台相册公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/album")
public class FrontAlbumController {

    private final AlbumService albumService;

    /** 查询相册列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Album>> list() {
        return ApiResponse.success(albumService.list(new LambdaQueryWrapper<Album>().orderByAsc(Album::getSort).orderByDesc(Album::getCreateTime)));
    }
}

