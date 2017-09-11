package com.vip.leona.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class RestApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleControllerException(Exception ex, WebRequest request) {
        if (ex instanceof BusinessException) {
            return handleBusinessException((BusinessException) ex, request);
        }
        logger.error("unknown exception:", ex);
        BusinessException be = new BusinessException(ex);
        return handleBusinessException(be, request);
    }

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    private ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        logger.info("get Business Exception:" + ex.getResult().toString());
        return handleExceptionInternal(ex, ex.getResult(), headers, status, request);
    }
}
