package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章实体。
 */
@Data
@TableName("article")
public class Article {

    /** 文章 ID。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 文章标题。 */
    private String title;

    /** 固定链接标识。 */
    private String slug;

    /** 封面图地址。 */
    private String cover;

    /** 文章摘要。 */
    private String summary;

    /** Markdown 正文。 */
    private String content;

    /** 分类 ID。 */
    private Long categoryId;

    /** 状态：0 草稿，1 发布。 */
    private Integer status;

    /** 是否置顶：0 否，1 是。 */
    private Integer isTop;

    /** 是否推荐：0 否，1 是。 */
    private Integer isRecommend;

    /** 浏览量。 */
    private Integer views;

    /** SEO 标题。 */
    private String seoTitle;

    /** SEO 描述。 */
    private String seoDescription;

    /** 发布时间。 */
    private LocalDateTime publishTime;

    /** 创建时间。 */
    private LocalDateTime createTime;

    /** 更新时间。 */
    private LocalDateTime updateTime;

    /** 逻辑删除标记：0 未删除，1 已删除。 */
    @TableLogic
    private Integer deleted;
}
