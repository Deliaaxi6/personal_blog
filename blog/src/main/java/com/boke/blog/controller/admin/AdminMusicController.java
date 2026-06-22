package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Music;
import com.boke.blog.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台音乐管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/music")
public class AdminMusicController {

    private final MusicService musicService;

    /** 查询音乐列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Music>> list() {
        return ApiResponse.success(musicService.list(new LambdaQueryWrapper<Music>().orderByAsc(Music::getSort).orderByDesc(Music::getCreateTime)));
    }

    /** 查询音乐详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Music> detail(@PathVariable Long id) {
        return ApiResponse.success(musicService.getById(id));
    }

    /** 新增音乐。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody Music body) {
        musicService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改音乐。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody Music body) {
        body.setId(id);
        musicService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除音乐。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        musicService.removeById(id);
        return ApiResponse.success();
    }
}

