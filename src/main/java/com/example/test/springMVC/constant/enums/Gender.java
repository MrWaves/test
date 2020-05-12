package com.example.test.springMVC.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Package: com.example.test.springMVC.constant.enums
 * @Author: Mr.Waves
 * @Date: 2020-04-28 13:12
 * @Description:
 **/
@AllArgsConstructor
@Getter
public enum Gender implements BaseEnum {
    BOY(1,"boy"),
    GIRL(0,"girl");

    private final Integer value;
    private final String desc;

    @Override
    public String toString() {
        return this.desc;
    }
}
