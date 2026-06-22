package com.boke.blog.controller.admin;

import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.About;
import com.boke.blog.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 后台关于页面管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/about")
public class AdminAboutController {

    private final AboutService aboutService;

    /** 查询关于页面内容。 */
    @GetMapping
    public ApiResponse<About> detail() {
        return ApiResponse.success(aboutService.getById(1L));
    }

    /** 保存关于页面内容。 */
    @PutMapping
    public ApiResponse<Void> save(@RequestBody About about) {
        about.setId(1L);
        aboutService.saveOrUpdate(about);
        return ApiResponse.success();
    }
}
