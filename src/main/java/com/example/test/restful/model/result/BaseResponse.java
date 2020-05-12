package com.example.test.restful.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.example.test.restful.vo
 * @Author: Mr.Waves
 * @Date: 2020-02-16 10:23
 * @Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public BaseResponse(Integer code) {
        this.code = code;
        this.msg = "操作成功";
        this.data = null;
    }

    public BaseResponse(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}
