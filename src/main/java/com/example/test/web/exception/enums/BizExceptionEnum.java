package com.example.test.web.exception.enums;

import com.example.test.web.exception.enums.AbstractExceptionEnum;

/**
 * @Package: com.example.test.web.exception
 * @Author: Mr.Waves
 * @Date: 2020-04-19 18:08
 * @Description:
 **/
public enum  BizExceptionEnum implements AbstractExceptionEnum {
    ;

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
