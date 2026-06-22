package com.boke.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boke.blog.entity.Article;
import com.boke.blog.vo.request.ArticleQuery;

public interface ArticleService extends IService<Article> {

    /** 分页查询文章，前台查询时只返回已发布文章。 */
    Page<Article> pageArticles(ArticleQuery query, boolean onlyPublished);

    /** 查询已发布文章详情。 */
    Article getPublishedDetail(Long id);
}
