package com.boke.blog.controller.auth;

import com.boke.blog.common.ApiResponse;
import com.boke.blog.service.BlogUserService;
import com.boke.blog.vo.request.LoginRequest;
import com.boke.blog.vo.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 后台登录接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final BlogUserService blogUserService;

    /** 账号密码登录。 */
    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.success(blogUserService.login(request));
    }
}
