package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 相册图片实体。
 */
@Data
@TableName("album_image")
public class AlbumImage {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long albumId;
    private String url;
    private String caption;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
