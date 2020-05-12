package com.example.test.web.exception.aop;

import com.example.test.restful.model.result.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Package: com.example.test.web.exception
 * @Author: Mr.Waves
 * @Date: 2020-04-15 12:20
 * @Description:
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(InstantiationException.class)
    public void handleException(InstantiationException e) {
        log.error(e.getClass().getName());
        log.error(e.getLocalizedMessage());
    }

    @ExceptionHandler(IllegalAccessException.class)
    public void handleException(IllegalAccessException e) {
        log.error(e.getClass().getName());
        log.error(e.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String message = String.format("%s: %s", error.getField(), error.getDefaultMessage());
        log.error(message);

        return new BaseResponse(400,message );
    }
}
