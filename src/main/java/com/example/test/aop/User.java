package com.example.test.aop;

import lombok.Data;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-03 11:49
 * @Description: 用户模型
 **/
@Data
public class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
