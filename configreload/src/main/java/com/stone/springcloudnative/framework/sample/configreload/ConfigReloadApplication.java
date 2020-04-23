package com.stone.springcloudnative.framework.sample.configreload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@Slf4j
public class ConfigReloadApplication {
    public static void main(String[] args) {
        log.info("ConfigReloadApplication  start... ");
        SpringApplication.run(ConfigReloadApplication.class, args);

    }

}
