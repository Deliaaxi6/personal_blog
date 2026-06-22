package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.Comment;
import com.boke.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台评论公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/comment")
public class FrontCommentController {

    private final CommentService commentService;

    /** 查询文章已审核评论。 */
    @GetMapping("/article/{articleId}")
    public ApiResponse<List<Comment>> articleComments(@PathVariable Long articleId) {
        return ApiResponse.success(commentService.list(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getArticleId, articleId)
                .eq(Comment::getStatus, 1)
                .orderByAsc(Comment::getCreateTime)));
    }

    /** 提交评论，默认进入待审核状态。 */
    @PostMapping("/add")
    public ApiResponse<Long> add(@RequestBody Comment comment) {
        comment.setStatus(0);
        commentService.save(comment);
        return ApiResponse.success(comment.getId());
    }
}
