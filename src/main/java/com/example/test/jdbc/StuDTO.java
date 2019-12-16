package com.example.test.jdbc;

import lombok.Data;

import java.util.Date;

/**
 * @Author: bo.wang
 * @Date: 2017/12/25
 * @Project: test
 */
@Data
public class StuDTO {
    private Long id;
    private String name;
    private Date createdAt;

    public StuDTO(String name) {
        this.name = name;
    }
}
