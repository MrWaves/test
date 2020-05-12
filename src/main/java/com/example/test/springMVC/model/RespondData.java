package com.example.test.springMVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Package: com.example.test.springMVC.model.result
 * @Author: Mr.Waves
 * @Date: 2020-04-20 14:24
 * @Description:
 **/
@Data
public class RespondData<T> {
    private Integer code;
    private String message;
    private T data;

    public RespondData(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public RespondData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
