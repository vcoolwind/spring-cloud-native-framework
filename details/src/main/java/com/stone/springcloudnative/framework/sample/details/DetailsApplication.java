package com.stone.springcloudnative.framework.sample.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DetailsApplication {
    public static boolean isUP = true;

    public static void main(String[] args) {
        SpringApplication.run(DetailsApplication.class, args);
    }
}
