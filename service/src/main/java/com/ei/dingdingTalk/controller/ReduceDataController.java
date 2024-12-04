package com.ei.dingdingTalk.controller;

import com.ei.dingdingTalk.service.DeduceDataService;
import com.ei.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/reduce")
@Slf4j
public class ReduceDataController {
    @Autowired
    @Qualifier("b2bDataService")
    private DeduceDataService b2bDataService;

    @Autowired
    @Qualifier("ztthDataService")
    private DeduceDataService ztthDataService;

    @RequestMapping("/all")
    public Result thirdPartyDataCollect() {
        long start = System.currentTimeMillis();
        CompletableFuture<List<String>> b2bData = b2bDataService.getThirdPartyData();
        CompletableFuture<List<String>> ztthData = ztthDataService.getThirdPartyData();
        CompletableFuture<Void> allOff = CompletableFuture.allOf(b2bData, ztthData);
        try {
            allOff.get();
            List<String> b2b = b2bData.get();
            List<String> ztth = ztthData.get();
            List<String> data = new ArrayList<>(b2b);
            data.addAll(ztth);
            data.forEach(System.out::println);
        }catch(InterruptedException | ExecutionException e) {
            log.error("error: ", e);
        }
        long end = System.currentTimeMillis();
        log.info("time consumed: {}", end - start);
        return Result.success("success");
    }
}
