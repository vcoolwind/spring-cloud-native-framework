package com.stone.springcloudnative.framework.sample.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.stone.springcloudnative.framework.sample.details.DetailsApplication.isUP;

@Component()
@Endpoint(id = "healthz", enableByDefault = true) //设置 id，并选择是否默认开启
@Slf4j
public class AppHealthyEndPoint {
    private static final String VERSION = "v1.0.0";

    @ReadOperation
    public Health healthz() throws BizException {

        boolean isOk = check();
        Health.Builder builder = null;
        if (isOk) {
            log.info("healthz ok");
            builder = Health.up();
        } else {
            //builder = Health.down();
            log.info("healthz fail");
            throw new BizException("healthy check fail",null,false,false);
        }
        //add some properties here
        return builder.withDetail("version", VERSION).withDetail("isUP", isUP).build();
    }

    private boolean check() {
        return isUP;
    }

}


