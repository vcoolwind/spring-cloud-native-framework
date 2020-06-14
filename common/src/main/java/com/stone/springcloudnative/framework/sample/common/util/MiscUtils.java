package com.stone.springcloudnative.framework.sample.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MiscUtils {
    private static Random random=new Random();
    public static void showHeaders(HttpServletRequest request) {
        if (request != null) {
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String key = headerNames.nextElement();
                    log.info("header: {}={}", key, request.getHeader(key));
                }
                return;
            }
        }
        log.warn("request is null or headerNames is null");
    }

    public static void sleep(long timeoutMillise) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutMillise);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long random(int bound){
      return   random.nextInt(bound);
    }
}
