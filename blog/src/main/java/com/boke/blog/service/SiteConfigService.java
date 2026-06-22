package com.boke.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boke.blog.entity.SiteConfig;

import java.util.Map;

public interface SiteConfigService extends IService<SiteConfig> {

    /** 查询公开站点配置，并转换为 key-value 结构。 */
    Map<String, String> getPublicConfigMap();
}
