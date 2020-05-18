package com.stone.springcloudnative.framework.sample.details;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myHealth", enableByDefault = true) //设置 id，并选择是否默认开启
public class MyHealthyEndPoint {

    @ReadOperation
    public String get() {
        return "{\"status\":\"UP\"}";
    }
}
