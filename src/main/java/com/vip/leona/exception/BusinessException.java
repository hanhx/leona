package com.vip.leona.exception;

import com.vip.leona.util.ResultUtils;

/**
 *
 */
public class BusinessException extends RuntimeException {
    private Result result;

    /**
     * @param statusCode
     * @param key
     * @param cause
     * @param param
     */
    public BusinessException(int statusCode, String key, Throwable cause, Object... param) {
        super(cause);
        result = (Result) ResultUtils.getInstance(false, statusCode, key , null , param);
    }

    /**
     * @param statusCode
     * @param key
     * @param cause
     */
    public BusinessException(int statusCode, String key, Throwable cause) {
        super(cause);
        result = (Result) ResultUtils.getInstance(false, statusCode, key, null);
    }

    /**
     * @param cause
     */
    public BusinessException(Throwable cause) {
        super(cause);

        result = (Result) ResultUtils.getInstance(false, -1, "Exception", null);
        result.setMessage(cause.getMessage());

    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
