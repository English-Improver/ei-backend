package com.ei.dingdingTalk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service("ztthDataService")
@Slf4j
public class ZtthDataServiceImpl implements DeduceDataService{
    @Async
    @Override
    public CompletableFuture<List<String>> getThirdPartyData() {
        log.info("ztth task executing, time: {}", System.currentTimeMillis());
        List<String> dataFromZttth = new ArrayList<>();
        dataFromZttth.add("data1");
        dataFromZttth.add("data1");
        dataFromZttth.add("data1");
        dataFromZttth.add("data1");
        dataFromZttth.add("data1");
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start("test");
            Thread.sleep(8000);
            stopWatch.stop();
        } catch (IllegalArgumentException | InterruptedException e) {
            e.printStackTrace();
        }
        log.info("ztth task finish, time: {}", System.currentTimeMillis());
        return CompletableFuture.completedFuture(dataFromZttth);
    }
}
