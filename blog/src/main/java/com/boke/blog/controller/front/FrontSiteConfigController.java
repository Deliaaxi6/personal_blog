package com.boke.blog.controller.front;

import com.boke.blog.common.ApiResponse;
import com.boke.blog.service.SiteConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 前台站点配置公开接口。
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/site")
public class FrontSiteConfigController {

    private final SiteConfigService siteConfigService;

    /** 查询公开站点配置。 */
    @GetMapping("/config")
    public ApiResponse<Map<String, String>> config() {
        return ApiResponse.success(siteConfigService.getPublicConfigMap());
    }
}
