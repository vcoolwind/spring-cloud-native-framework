package com.stone.springcloudnative.framework.sample.ratings;

import com.stone.springcloudnative.framework.sample.common.log.LoggerAspect;
import com.stone.springcloudnative.framework.sample.common.mesh.FeginInterceptor;
import com.stone.springcloudnative.framework.sample.common.mesh.FeignConfiguration;
import com.stone.springcloudnative.framework.sample.common.mesh.HystrixRequestAttributeAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({LoggerAspect.class, FeginInterceptor.class, FeignConfiguration.class, HystrixRequestAttributeAutoConfiguration.class})
@Slf4j
public class RatingsApplication {
    public static void main(String[] args) {
        log.info("RatingsApplication start ...");
        SpringApplication.run( RatingsApplication.class, args);
    }
}