package com.boke.blog.vo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleRequest {

    @NotBlank(message = "文章标题不能为空")
    private String title;

    private String slug;

    private String cover;

    private String summary;

    @NotBlank(message = "文章内容不能为空")
    private String content;

    private Long categoryId;

    @NotNull(message = "文章状态不能为空")
    private Integer status = 0;

    private Integer isTop = 0;

    private Integer isRecommend = 0;

    private String seoTitle;

    private String seoDescription;

    private LocalDateTime publishTime;
}
