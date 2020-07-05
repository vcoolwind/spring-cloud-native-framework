package com.stone.springcloudnative.framework.sample.reviews.reviews;

import com.purgeteam.dynamic.config.starter.event.ActionConfigEvent;
import com.stone.springcloudnative.framework.sample.reviews.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class NacosListener implements ApplicationListener<ActionConfigEvent> {

    @Value("${logLevel:debug}")
    private String logLevel;

    @Override
    public void onApplicationEvent(ActionConfigEvent event) {
        log.info("接收事件:{}",event.getPropertyMap());
        Set<Map.Entry<String, HashMap>> entries = event.getPropertyMap().entrySet();
        for (Map.Entry<String, HashMap> entry : entries) {
            String configKey = entry.getKey();
            if("logLevel".equals(configKey)){
                HashMap value = entry.getValue();
                Object configValueBefore = value.get("before");
                Object configValueAfter = value.get("after");
                //设置日志级别
                LogUtils.setLevel("root",configValueAfter.toString());
            }
        }
    }
}