package com.srq.ai.exception;

import java.io.Serial;

/**
 * @author yitiansong
 * @since 10/11/24
 * 大模型响应为null异常
 */

public class ResponseIsNullException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public ResponseIsNullException() {
        super();
    }
    public ResponseIsNullException(String message) {
        super(message);
    }
}
