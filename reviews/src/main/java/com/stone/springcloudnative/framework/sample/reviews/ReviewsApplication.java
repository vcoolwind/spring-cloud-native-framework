package com.stone.springcloudnative.framework.sample.reviews;

import com.stone.springcloudnative.framework.sample.common.log.LoggerAspect;
import com.stone.springcloudnative.framework.sample.common.mesh.FeginInterceptor;
import com.stone.springcloudnative.framework.sample.common.mesh.FeignConfiguration;
import com.stone.springcloudnative.framework.sample.common.mesh.HystrixRequestAttributeAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@Import({LoggerAspect.class, FeginInterceptor.class, FeignConfiguration.class, HystrixRequestAttributeAutoConfiguration.class})
public class ReviewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewsApplication.class, args);
    }
}
