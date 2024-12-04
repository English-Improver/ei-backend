package com.ei.dingdingTalk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
@Service("b2bDataService")
@Slf4j
public class B2BDataServiceImpl implements DeduceDataService {

    @Async
    @Override
    public CompletableFuture<List<String>> getThirdPartyData() {
        log.info("B2B task executing: ");
        System.out.println(System.currentTimeMillis());
        List<String> b2bList = new ArrayList<>();
        b2bList.add("b2b1");
        b2bList.add("b2b1");
        b2bList.add("b2b1");
        b2bList.add("b2b1");
        b2bList.add("b2b1");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Thread.sleep(5000);
        }catch(InterruptedException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        stopWatch.stop();
        log.info("B2B task executed");
        return CompletableFuture.completedFuture(b2bList);



    }
}
