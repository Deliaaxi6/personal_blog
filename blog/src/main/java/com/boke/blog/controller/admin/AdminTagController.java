package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Tag;
import com.boke.blog.service.TagService;
import com.boke.blog.vo.request.TagRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台标签管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/tag")
public class AdminTagController {

    private final TagService tagService;

    /** 查询标签列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Tag>> list() {
        return ApiResponse.success(tagService.list(new LambdaQueryWrapper<Tag>().orderByDesc(Tag::getCreateTime)));
    }

    /** 新增标签。 */
    @PostMapping
    public ApiResponse<Long> create(@Valid @RequestBody TagRequest request) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(request, tag);
        tagService.save(tag);
        return ApiResponse.success(tag.getId());
    }

    /** 修改标签。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @Valid @RequestBody TagRequest request) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(request, tag);
        tag.setId(id);
        tagService.updateById(tag);
        return ApiResponse.success();
    }

    /** 删除标签。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        tagService.removeById(id);
        return ApiResponse.success();
    }
}
