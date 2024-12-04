package com.ei.autotask.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author yitiansong
 * @since 11/12/24
 */
@Service
@Slf4j
public class MonitorServiceImpl implements MonitorService {
    @Override
    public Integer getCurrentData() {
        return 123;
    }
    @Scheduled(fixedRate = 60000)
    public void checkData() {
        log.info("定时检测开始，time：{}", System.currentTimeMillis());
        Integer dataa = getCurrentData();
        if (dataa >= 100) {
            log.warn("数据异常，{}", dataa);
        }
        log.info("本次检查结束，time：{}", System.currentTimeMillis());
    }
}
