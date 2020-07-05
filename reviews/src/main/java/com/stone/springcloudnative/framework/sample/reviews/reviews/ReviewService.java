package com.stone.springcloudnative.framework.sample.reviews.reviews;

import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.stereotype.Service;

import static com.stone.springcloudnative.framework.sample.common.util.MiscUtils.sleepRandom;

@Service
@Slf4j
public class ReviewService {
    @Trace
    public String doAction1(String argument1) {
        ActiveSpan.tag("doAction1", argument1);
        log.info("doAction1 start");
        sleepRandom(500);
        log.info("doAction1 end");
        return doAction2("doAction1:" + argument1);
    }

    @Trace
    public String doAction2(String argument1) {
        ActiveSpan.tag("doAction2", argument1);
        log.info("doAction2 start");
        sleepRandom(500);
        log.info("doAction2 end");
        return doAction3("doAction2:" + argument1);
    }

    @Trace
    public String doAction3(String argument1) {
        ActiveSpan.tag("doAction3", argument1);
        log.info("doAction3 start");
        sleepRandom(500);
        log.info("doAction3 end");
        return "doAction3:" + argument1;
    }

}
