package com.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author yitiansong
 * 通用日志类,但是为了日子输出更容易定位到问题,因此已弃用
 * 2024/8/4
 */
@Deprecated
public class EILog {
    public static final Logger logger = LogManager.getLogger(EILog.class);
}
