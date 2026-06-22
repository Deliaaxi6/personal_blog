package com.boke.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boke.blog.entity.BlogUser;
import com.boke.blog.vo.request.LoginRequest;
import com.boke.blog.vo.response.LoginResponse;

public interface BlogUserService extends IService<BlogUser> {

    /** 后台账号密码登录。 */
    LoginResponse login(LoginRequest request);
}
