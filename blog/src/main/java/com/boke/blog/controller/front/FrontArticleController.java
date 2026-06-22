package com.boke.blog.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.common.PageResult;
import com.boke.blog.entity.Article;
import com.boke.blog.service.ArticleService;
import com.boke.blog.vo.request.ArticleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 前台文章公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/article")
public class FrontArticleController {

    private final ArticleService articleService;

    /** 分页查询已发布文章。 */
    @GetMapping("/list")
    public ApiResponse<PageResult<Article>> list(ArticleQuery query) {
        Page<Article> page = articleService.pageArticles(query, true);
        return ApiResponse.success(new PageResult<>(page.getTotal(), page.getRecords()));
    }

    /** 查询已发布文章详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Article> detail(@PathVariable Long id) {
        return ApiResponse.success(articleService.getPublishedDetail(id));
    }
}
