package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Category;
import com.boke.blog.service.CategoryService;
import com.boke.blog.vo.request.CategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台分类管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

    private final CategoryService categoryService;

    /** 查询分类列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Category>> list() {
        List<Category> categories = categoryService.list(new LambdaQueryWrapper<Category>()
                .orderByAsc(Category::getSort)
                .orderByDesc(Category::getCreateTime));
        return ApiResponse.success(categories);
    }

    /** 新增分类。 */
    @PostMapping
    public ApiResponse<Long> create(@Valid @RequestBody CategoryRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        categoryService.save(category);
        return ApiResponse.success(category.getId());
    }

    /** 修改分类。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @Valid @RequestBody CategoryRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        category.setId(id);
        categoryService.updateById(category);
        return ApiResponse.success();
    }

    /** 删除分类。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        categoryService.removeById(id);
        return ApiResponse.success();
    }
}
