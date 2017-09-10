package com.vip.leona.exception;

import lombok.Data;

import java.util.Map;

/**
 * common result
 */
@Data
public class Result {

    private boolean success = true;

    private String message;

    private int statusCode;

    private String key;

    private Object resultObj;

    public Result() {
        super();
    }

    public Result(boolean success, String message, int statusCode, String key) {
        super();
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.key = key;
    }

    public Result(boolean success, String message, int statusCode, String key, Object resultObj) {
        super();
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.key = key;
        this.resultObj = resultObj;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", key='" + key + '\'' +
                ", resultObj=" + resultObj +
                '}';
    }
}
