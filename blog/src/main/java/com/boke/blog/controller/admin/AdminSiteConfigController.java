package com.boke.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.boke.blog.common.ApiResponse;
import com.boke.blog.entity.SiteConfig;
import com.boke.blog.service.SiteConfigService;
import com.boke.blog.vo.request.SiteConfigRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台站点配置管理接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/site/config")
public class AdminSiteConfigController {

    private final SiteConfigService siteConfigService;

    /** 查询站点配置列表。 */
    @GetMapping("/list")
    public ApiResponse<List<SiteConfig>> list() {
        return ApiResponse.success(siteConfigService.list(new LambdaQueryWrapper<SiteConfig>().orderByAsc(SiteConfig::getId)));
    }

    /** 新增站点配置。 */
    @PostMapping
    public ApiResponse<Long> create(@Valid @RequestBody SiteConfigRequest request) {
        SiteConfig siteConfig = new SiteConfig();
        BeanUtils.copyProperties(request, siteConfig);
        siteConfigService.save(siteConfig);
        return ApiResponse.success(siteConfig.getId());
    }

    /** 修改站点配置。 */
    @PutMapping("/{id}")
    public ApiResponse<Void> update(@PathVariable Long id, @Valid @RequestBody SiteConfigRequest request) {
        SiteConfig siteConfig = new SiteConfig();
        BeanUtils.copyProperties(request, siteConfig);
        siteConfig.setId(id);
        siteConfigService.updateById(siteConfig);
        return ApiResponse.success();
    }

    /** 根据配置键修改站点配置。 */
    @PutMapping("/key/{configKey}")
    public ApiResponse<Void> updateByKey(@PathVariable String configKey, @RequestBody SiteConfigRequest request) {
        siteConfigService.update(new LambdaUpdateWrapper<SiteConfig>()
                .eq(SiteConfig::getConfigKey, configKey)
                .set(SiteConfig::getConfigValue, request.getConfigValue())
                .set(SiteConfig::getRemark, request.getRemark()));
        return ApiResponse.success();
    }

    /** 删除站点配置。 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        siteConfigService.removeById(id);
        return ApiResponse.success();
    }
}
