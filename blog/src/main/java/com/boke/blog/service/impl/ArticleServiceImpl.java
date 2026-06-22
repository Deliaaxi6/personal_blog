package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.common.ErrorCode;
import com.boke.blog.common.exception.BusinessException;
import com.boke.blog.entity.Article;
import com.boke.blog.mapper.ArticleMapper;
import com.boke.blog.service.ArticleService;
import com.boke.blog.vo.request.ArticleQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public Page<Article> pageArticles(ArticleQuery query, boolean onlyPublished) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<Article>()
                .eq(onlyPublished, Article::getStatus, 1)
                .eq(query.getStatus() != null && !onlyPublished, Article::getStatus, query.getStatus())
                .eq(query.getCategoryId() != null, Article::getCategoryId, query.getCategoryId())
                .and(StringUtils.hasText(query.getKeyword()), w -> w
                        .like(Article::getTitle, query.getKeyword())
                        .or()
                        .like(Article::getSummary, query.getKeyword()))
                .orderByDesc(Article::getIsTop)
                .orderByDesc(Article::getPublishTime)
                .orderByDesc(Article::getCreateTime);
        return page(new Page<>(query.getPageNum(), query.getPageSize()), wrapper);
    }

    @Override
    public Article getPublishedDetail(Long id) {
        Article article = lambdaQuery()
                .eq(Article::getId, id)
                .eq(Article::getStatus, 1)
                .one();
        if (article == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND, "文章不存在或未发布");
        }
        lambdaUpdate().eq(Article::getId, id).setSql("views = views + 1").update();
        article.setViews(article.getViews() == null ? 1 : article.getViews() + 1);
        return article;
    }
}
