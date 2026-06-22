package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Comment;
import com.boke.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台评论管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/comment")
public class AdminCommentController {

    private final CommentService commentService;

    /** 查询评论列表。 */
    @GetMapping("/list")
    public ApiResponse<List<Comment>> list() {
        return ApiResponse.success(commentService.list(new LambdaQueryWrapper<Comment>().orderByDesc(Comment::getCreateTime)));
    }

    /** 查询评论详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Comment> detail(@PathVariable Long id) {
        return ApiResponse.success(commentService.getById(id));
    }

    /** 新增评论。 */
    @PostMapping
    public ApiResponse<Long> create(@RequestBody Comment body) {
        commentService.save(body);
        return ApiResponse.success(body.getId());
    }

    /** 修改评论。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @RequestBody Comment body) {
        body.setId(id);
        commentService.updateById(body);
        return ApiResponse.success();
    }

    /** 删除评论。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        commentService.removeById(id);
        return ApiResponse.success();
    }
}
