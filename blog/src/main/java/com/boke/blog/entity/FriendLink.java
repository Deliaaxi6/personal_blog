package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 友链实体。
 */
@Data
@TableName("friend_link")
public class FriendLink {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String siteName;
    private String siteUrl;
    private String avatar;
    private String description;
    private String themeColor;
    private Integer sort;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
