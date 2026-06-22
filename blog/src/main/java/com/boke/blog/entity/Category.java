package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章分类实体。
 */
@Data
@TableName("category")
public class Category {

    /** 分类 ID。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 分类名称。 */
    private String name;

    /** 排序权重，数值越小越靠前。 */
    private Integer sort;

    /** 创建时间。 */
    private LocalDateTime createTime;

    /** 更新时间。 */
    private LocalDateTime updateTime;
}
