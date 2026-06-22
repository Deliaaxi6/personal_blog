package com.boke.blog.controller.front;

import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.About;
import com.boke.blog.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 前台关于页面公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/about")
public class FrontAboutController {

    private final AboutService aboutService;

    /** 查询关于页面内容。 */
    @GetMapping
    public ApiResponse<About> detail() {
        return ApiResponse.success(aboutService.getById(1L));
    }
}
