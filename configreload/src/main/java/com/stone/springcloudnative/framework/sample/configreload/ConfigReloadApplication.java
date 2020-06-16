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
    /**
     * VM添加 -javaagent:C:\idea_workspace\spring-cloud-native-framework\agent\skywalking-agent.jar -Dskywalking.agent.service_name=configreload
     *  C:\idea_workspace\spring-cloud-native-framework\agent\config\agent.config 已经定义了如何连接OAP
     * @param args
     */
    public static void main(String[] args) {
        log.info("ConfigReloadApplication  start... ");
        SpringApplication.run(ConfigReloadApplication.class, args);

    }

}
