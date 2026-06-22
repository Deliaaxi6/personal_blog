package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.common.PageResult;
import com.boke.blog.entity.Article;
import com.boke.blog.service.ArticleService;
import com.boke.blog.vo.request.ArticleQuery;
import com.boke.blog.vo.request.ArticleRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 后台文章管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/article")
public class AdminArticleController {

    private final ArticleService articleService;

    /** 分页查询文章列表。 */
    @GetMapping("/list")
    public ApiResponse<PageResult<Article>> list(ArticleQuery query) {
        Page<Article> page = articleService.pageArticles(query, false);
        return ApiResponse.success(new PageResult<>(page.getTotal(), page.getRecords()));
    }

    /** 查询文章详情。 */
    @GetMapping("/{id}")
    public ApiResponse<Article> detail(@PathVariable Long id) {
        return ApiResponse.success(articleService.getById(id));
    }

    /** 新增文章。 */
    @PostMapping
    public ApiResponse<Long> create(@Valid @RequestBody ArticleRequest request) {
        Article article = new Article();
        BeanUtils.copyProperties(request, article);
        article.setViews(0);
        article.setDeleted(0);
        articleService.save(article);
        return ApiResponse.success(article.getId());
    }

    /** 修改文章。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @Valid @RequestBody ArticleRequest request) {
        Article article = new Article();
        BeanUtils.copyProperties(request, article);
        article.setId(id);
        articleService.updateById(article);
        return ApiResponse.success();
    }

    /** 删除文章。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        articleService.removeById(id);
        return ApiResponse.success();
    }
}
