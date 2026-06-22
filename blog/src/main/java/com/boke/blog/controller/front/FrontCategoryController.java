package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Category;
import com.boke.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台分类公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/category")
public class FrontCategoryController {

    private final CategoryService categoryService;

    /** 查询全部分类。 */
    @GetMapping("/all")
    public ApiResponse<List<Category>> all() {
        return ApiResponse.success(categoryService.list(new LambdaQueryWrapper<Category>()
                .orderByAsc(Category::getSort)
                .orderByDesc(Category::getCreateTime)));
    }
}
