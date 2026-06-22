package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Album;
import com.boke.blog.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台相册管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/album")
public class AdminAlbumController {

    private final AlbumService albumService;

    /** 查询相册列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Album>> list() {
        return ApiResponse.success(albumService.list(new LambdaQueryWrapper<Album>().orderByAsc(Album::getSort).orderByDesc(Album::getCreateTime)));
    }

    /** 查询相册详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Album> detail(@PathVariable Long id) {
        return ApiResponse.success(albumService.getById(id));
    }

    /** 新增相册。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody Album body) {
        albumService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改相册。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody Album body) {
        body.setId(id);
        albumService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除相册。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        albumService.removeById(id);
        return ApiResponse.success();
    }
}

