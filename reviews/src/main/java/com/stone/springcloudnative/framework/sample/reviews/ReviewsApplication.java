package com.stone.springcloudnative.framework.sample.reviews;

import com.purgeteam.dynamic.config.starter.annotation.EnableDynamicConfigEvent;
import com.stone.springcloudnative.framework.sample.common.log.LoggerAspect;
import com.stone.springcloudnative.framework.sample.common.mesh.FeginInterceptor;
import com.stone.springcloudnative.framework.sample.common.mesh.HystrixRequestAttributeAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableDynamicConfigEvent
public class ReviewsApplication {

    /**
     * VM添加 -javaagent:C:\idea_workspace\spring-cloud-native-framework\agent\skywalking-agent.jar -Dskywalking.agent.service_name=reviews
     *  C:\idea_workspace\spring-cloud-native-framework\agent\config\agent.config 已经定义了如何连接OAP
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ReviewsApplication.class, args);
    }
}
