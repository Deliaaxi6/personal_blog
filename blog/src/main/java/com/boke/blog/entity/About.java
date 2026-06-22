package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 关于页面实体。
 */
@Data
@TableName("about")
public class About {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String content;
    private LocalDateTime updateTime;
}
