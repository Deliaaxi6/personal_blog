package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Project;
import com.boke.blog.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台项目管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/project")
public class AdminProjectController {

    private final ProjectService projectService;

    /** 查询项目列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Project>> list() {
        return ApiResponse.success(projectService.list(new LambdaQueryWrapper<Project>().orderByAsc(Project::getSort).orderByDesc(Project::getCreateTime)));
    }

    /** 查询项目详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Project> detail(@PathVariable Long id) {
        return ApiResponse.success(projectService.getById(id));
    }

    /** 新增项目。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody Project body) {
        projectService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改项目。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody Project body) {
        body.setId(id);
        projectService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除项目。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        projectService.removeById(id);
        return ApiResponse.success();
    }
}

