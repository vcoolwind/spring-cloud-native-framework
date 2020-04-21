package com.stone.springcloudnative.framework.sample.reviews.configreload;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


//@FeignClient(name = "${configreload.servicename:configreload}", fallback = ConfigReloadClientFallback.class)
@FeignClient(name = "${configreload.servicename:configreload}", fallbackFactory = ConfigReloadClientFallbackFactory.class)
public interface ConfigReloadClient {

    @GetMapping(value = "/info")
    RemoteConfig getRemoteConfig();


}
