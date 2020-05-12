package com.example.test.generic.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.example.test.generic.entity
 * @Author: Mr.Waves
 * @Date: 2020-04-15 11:43
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserParam {
    private Long id;
    private String name;
}
