package com.boke.blog.service.impl;

import com.boke.blog.common.ErrorCode;
import com.boke.blog.common.exception.BusinessException;
import com.boke.blog.entity.BlogUser;
import com.boke.blog.mapper.BlogUserMapper;
import com.boke.blog.service.BlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.util.JwtUtil;
import com.boke.blog.vo.request.LoginRequest;
import com.boke.blog.vo.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {
        BlogUser user = lambdaQuery().eq(BlogUser::getUsername, request.getUsername()).one();
        if (user == null || user.getStatus() == null || user.getStatus() != 1) {
            throw new BusinessException(ErrorCode.UNAUTHORIZED, "账号不存在或已禁用");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.UNAUTHORIZED, "账号或密码错误");
        }
        return new LoginResponse(jwtUtil.generateToken(user.getId()), user.getId(), user.getUsername(), user.getNickname(), user.getRole());
    }
}
