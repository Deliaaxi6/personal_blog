package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章标签实体。
 */
@Data
@TableName("tag")
public class Tag {

    /** 标签 ID。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 标签名称。 */
    private String name;

    /** 创建时间。 */
    private LocalDateTime createTime;

    /** 更新时间。 */
    private LocalDateTime updateTime;
}
