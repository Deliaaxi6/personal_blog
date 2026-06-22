package com.boke.blog.vo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleQuery extends PageQuery {

    private String keyword;

    private Long categoryId;

    private Integer status;
}
