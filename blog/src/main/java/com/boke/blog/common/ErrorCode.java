package com.boke.blog.common;

import lombok.Getter;

@Getter
public enum ErrorCode {
    BAD_REQUEST(400, "参数错误"),
    UNAUTHORIZED(401, "未登录"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "数据不存在"),
    INTERNAL_ERROR(500, "服务器异常");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
