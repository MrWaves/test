package com.example.test.java;

import lombok.Data;

/**
 * @Package: com.example.test.java
 * @Author: Mr.Waves
 * @Date: 2020-02-03 13:38
 * @Description:
 **/
@Data
public class Student {
    private Integer id;
    private String name;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }
}
