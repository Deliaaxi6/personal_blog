package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.AlbumImage;
import com.boke.blog.service.AlbumImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台相册图片管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/album/image")
public class AdminAlbumImageController {

    private final AlbumImageService albumImageService;

    /** 查询相册图片列表。 */
    @GetMapping("/list")
    public ApiResponse<List<AlbumImage>> list() {
        return ApiResponse.success(albumImageService.list(new LambdaQueryWrapper<AlbumImage>().orderByAsc(AlbumImage::getSort).orderByDesc(AlbumImage::getCreateTime)));
    }

    /** 查询相册图片详情。 */
    @GetMapping("/{id}")
    public ApiResponse<AlbumImage> detail(@PathVariable Long id) {
        return ApiResponse.success(albumImageService.getById(id));
    }

    /** 新增相册图片。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody AlbumImage body) {
        albumImageService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改相册图片。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody AlbumImage body) {
        body.setId(id);
        albumImageService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除相册图片。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        albumImageService.removeById(id);
        return ApiResponse.success();
    }
}

