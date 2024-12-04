package com.ei.dingdingTalk.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DeduceDataService {
    public CompletableFuture<List<String>> getThirdPartyData();
}
