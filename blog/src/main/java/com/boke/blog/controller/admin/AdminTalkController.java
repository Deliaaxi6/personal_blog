package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Talk;
import com.boke.blog.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台说说管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/talk")
public class AdminTalkController {

    private final TalkService talkService;

    /** 查询说说列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Talk>> list() {
        return ApiResponse.success(talkService.list(new LambdaQueryWrapper<Talk>().orderByDesc(Talk::getCreateTime)));
    }

    /** 查询说说详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Talk> detail(@PathVariable Long id) {
        return ApiResponse.success(talkService.getById(id));
    }

    /** 新增说说。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody Talk body) {
        talkService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改说说。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody Talk body) {
        body.setId(id);
        talkService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除说说。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        talkService.removeById(id);
        return ApiResponse.success();
    }
}
