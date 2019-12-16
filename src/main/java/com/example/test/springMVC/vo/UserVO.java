package com.example.test.springMVC.vo;

import lombok.Data;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 10:50
 * @Description:
 **/
@Data
public class UserVO {
    private Integer age;
    private String name;

    public UserVO() {

    }
    public UserVO(Integer age, String name) {
        this.age=age;
        this.name=name;
    }
}
