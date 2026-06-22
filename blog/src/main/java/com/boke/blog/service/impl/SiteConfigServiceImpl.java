package com.boke.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boke.blog.entity.SiteConfig;
import com.boke.blog.mapper.SiteConfigMapper;
import com.boke.blog.service.SiteConfigService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SiteConfigServiceImpl extends ServiceImpl<SiteConfigMapper, SiteConfig> implements SiteConfigService {

    @Override
    public Map<String, String> getPublicConfigMap() {
        return list().stream()
                .collect(Collectors.toMap(SiteConfig::getConfigKey, SiteConfig::getConfigValue, (oldValue, newValue) -> newValue));
    }
}
