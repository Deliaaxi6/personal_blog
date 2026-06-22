package com.boke.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 站点配置实体。
 */
@Data
@TableName("site_config")
public class SiteConfig {

    /** 配置 ID。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 配置键。 */
    private String configKey;

    /** 配置值。 */
    private String configValue;

    /** 配置说明。 */
    private String remark;

    /** 创建时间。 */
    private LocalDateTime createTime;

    /** 更新时间。 */
    private LocalDateTime updateTime;
}
