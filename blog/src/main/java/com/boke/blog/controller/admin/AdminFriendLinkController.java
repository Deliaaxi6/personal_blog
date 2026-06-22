package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.FriendLink;
import com.boke.blog.service.FriendLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台友链管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/friend")
public class AdminFriendLinkController {

    private final FriendLinkService friendLinkService;

    /** 查询友链列表。 */
    @GetMapping("/list")
    public ApiResponse<List<FriendLink>> list() {
        return ApiResponse.success(friendLinkService.list(new LambdaQueryWrapper<FriendLink>().orderByAsc(FriendLink::getSort).orderByDesc(FriendLink::getCreateTime)));
    }

    /** 查询友链详情。 */
    @GetMapping("/{id}")
    public ApiResponse<FriendLink> detail(@PathVariable Long id) {
        return ApiResponse.success(friendLinkService.getById(id));
    }

    /** 新增友链。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody FriendLink body) {
        friendLinkService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改友链。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody FriendLink body) {
        body.setId(id);
        friendLinkService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除友链。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        friendLinkService.removeById(id);
        return ApiResponse.success();
    }
}

