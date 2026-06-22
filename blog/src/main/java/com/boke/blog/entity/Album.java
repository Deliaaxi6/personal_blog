package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 相册实体。
 */
@Data
@TableName("album")
public class Album {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String cover;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
