package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Project;
import com.boke.blog.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台项目公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/project")
public class FrontProjectController {

    private final ProjectService projectService;

    /** 查询项目列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Project>> list() {
        return ApiResponse.success(projectService.list(new LambdaQueryWrapper<Project>().eq(Project::getStatus, 1).orderByAsc(Project::getSort).orderByDesc(Project::getCreateTime)));
    }
}

