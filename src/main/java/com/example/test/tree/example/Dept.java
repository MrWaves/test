package com.example.test.tree.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Package: com.example.test.tree.example
 * @Author: Mr.Waves
 * @Date: 2020-04-02 00:07
 * @Description:
 **/
@AllArgsConstructor
@Data
public class Dept {
    private Long id;
    private Long pid;
    private String name;
}
