package com.stone.springcloudnative.framework.sample.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.stone.springcloudnative.framework.sample.details.DetailsApplication.isUP;

/**
 * take example by DiskSpaceHealthIndicator.java
 */
@Slf4j
@Component("DetailsAPP")
public class DetailsHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if (isUP) {
            // All will up when one up.
            log.info("healthz ok");
            builder.up().withDetail("isUP",isUP);
        } else {
            // extends AbstractHealthIndicator,All will down when one down.
            log.info("healthz fail");
            builder.down().withDetail("isUP",isUP);
        }
    }
}
