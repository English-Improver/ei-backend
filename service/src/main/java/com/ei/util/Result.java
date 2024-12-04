package com.ei.util;


import com.util.JSONUtils;

import java.io.Serial;
import java.util.Map;

/**
 * @author 86157
 * @date 2023/12/16
 */
public class Result implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private ResultType resultType;
    private Operation operation;
    private String message;
    private Map<String, Object> data;
    private String content;

    /**
     *
     * @param msg 描述消息
     * @param operation 操作
     * @param data 数据
     * @return Result
     */
    public static Result success(String msg, Operation operation, Map<String, Object> data, String content) {
        Result result = new Result();
        result.setMessage(msg);
        result.setResultType(ResultType.SUCCESS);
        result.setData(data);
        result.setOperation(operation);
        result.setContent(content);
        return result;
    }

    public static Result success(String msg, Operation operation) {
        return success(msg, operation, null, null);
    }
    public static Result success(Operation operation, Map<String, Object> data) {
        return success(null,operation, data, null);
    }

    public static Result success(String msg) {
        return success(msg, null, null, null);
    }

    public static <T> Result success(T content) {
        String jsonString = JSONUtils.toJSONString(content);
        return success("成功", null, null, jsonString);
    }
    public static Result success(Operation operation) {
        return success(null, operation, null, null);
    }

    public static Result fail(String msg, Operation operation, Map<String, Object> data) {
        Result result = new Result();
        result.setMessage(msg);
        result.setOperation(operation);
        result.setResultType(ResultType.FAIL);
        result.setData(data);
        return result;
    }
    public static Result fail(String msg, Operation operation) {
        return fail(msg, operation, null);
    }
    public static Result fail(String msg) {
        return fail(msg, null, null);
    }
    public static Result fail(Operation operation) {
        return fail(null, operation, null);
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setMessage(msg);
        result.setResultType(ResultType.FAIL);
        return result;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultType=" + resultType +
                ", operation=" + operation +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", content='" + content + '\'' +
                '}';
    }
}


