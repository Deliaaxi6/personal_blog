package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Tag;
import com.boke.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台标签公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/tag")
public class FrontTagController {

    private final TagService tagService;

    /** 查询全部标签。 */
    @GetMapping("/all")
    public ApiResponse<List<Tag>> all() {
        return ApiResponse.success(tagService.list(new LambdaQueryWrapper<Tag>().orderByDesc(Tag::getCreateTime)));
    }
}
