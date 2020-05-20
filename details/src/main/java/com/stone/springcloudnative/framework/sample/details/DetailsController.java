package com.stone.springcloudnative.framework.sample.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DetailsController {

    @GetMapping(value = "/")
    public String root() {
        return "hello details";
    }

    @GetMapping(value = "/details/{productId}")
    public ResponseEntity<Detail> getDetailByIsbn(@PathVariable("productId") String productId) {
        if (DetailsRepo.contains(productId)) {
            return new ResponseEntity<>(DetailsRepo.getDetail(productId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/details/down")
    public String setDown() {
        DetailsApplication.isUP = false;
        return "the server is down";
    }

    @GetMapping(value = "/details/up")
    public String setUp() {
        DetailsApplication.isUP = true;
        return "the server is up";
    }

    @GetMapping(value = "/details/gc")
    public String reqGC() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100000; i++) {
                            log.info("allocate " + i + "times");
                            allocateMemory();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {

                            }
                        }
                    }
                }
        ).start();
        return "reqGC start";
    }

    private void allocateMemory() {
        int sum = 100000;
        String[] arrs = new String[sum];
        for (int i = 0; i < sum; i++) {
            arrs[i] = "abcdefghijklmn" + i;
        }
    }
}
