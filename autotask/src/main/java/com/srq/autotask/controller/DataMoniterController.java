package com.srq.autotask.controller;

import com.srq.autotask.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yitiansong
 * @since 11/12/24
 */
@RestController
@RequestMapping("/monitor")
public class DataMoniterController {
    @Autowired
    private MonitorService monitorService;

    @Scheduled(fixedRate = 60000)
    public void checkData() {
//        log.info("定时检测开始，time：{}", System.currentTimeMillis());
        Integer dataa = monitorService.getCurrentData();
        if (dataa >= 100) {
//            log.warn("数据异常，{}", dataa);
        }
//        log.info("本次检查结束，time：{}", System.currentTimeMillis());
    }


}
