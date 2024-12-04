package com.ei.autotask.controller;


import com.ei.autotask.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yitiansong
 * @since 11/12/24
 */
@RestController
@RequestMapping("/monitor")
@Slf4j
public class DataMoniterController {
    @Autowired
    private MonitorService monitorService;




}
