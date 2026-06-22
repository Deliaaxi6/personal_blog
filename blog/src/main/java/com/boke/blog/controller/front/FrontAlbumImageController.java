package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.AlbumImage;
import com.boke.blog.service.AlbumImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台相册图片公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/album")
public class FrontAlbumImageController {

    private final AlbumImageService albumImageService;

    /** 查询指定相册下的图片。 */
    @GetMapping("/{albumId}/images")
    public ApiResponse<List<AlbumImage>> images(@PathVariable Long albumId) {
        return ApiResponse.success(albumImageService.list(new LambdaQueryWrapper<AlbumImage>()
                .eq(AlbumImage::getAlbumId, albumId)
                .orderByAsc(AlbumImage::getSort)
                .orderByDesc(AlbumImage::getCreateTime)));
    }
}
