package com.stone.springcloudnative.framework.sample.ratings;

import com.stone.springcloudnative.framework.sample.common.log.LoggerAspect;
import com.stone.springcloudnative.framework.sample.common.mesh.FeginInterceptor;
import com.stone.springcloudnative.framework.sample.common.mesh.FeignConfiguration;
import com.stone.springcloudnative.framework.sample.common.mesh.HystrixRequestAttributeAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({LoggerAspect.class, FeginInterceptor.class, FeignConfiguration.class, HystrixRequestAttributeAutoConfiguration.class})
public class RatingsApplication {
    public static void main(String[] args) {
        SpringApplication.run( RatingsApplication.class, args);
    }
}