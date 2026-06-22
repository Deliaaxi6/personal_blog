package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 音乐实体。
 */
@Data
@TableName("music")
public class Music {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String songName;
    private String artist;
    private String album;
    private String songUrl;
    private String cover;
    private Integer duration;
    private String sourceId;
    private Integer sort;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
