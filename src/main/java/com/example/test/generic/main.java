package com.example.test.generic;

import com.example.test.generic.entity.User;
import com.example.test.generic.model.param.UserParam;

/**
 * @Package: com.example.test.generic
 * @Author: Mr.Waves
 * @Date: 2020-04-15 12:05
 * @Description:
 **/
public class main {
    public static void main(String[] args) {
        UserParam userParam = new UserParam(1L, "Jack");
        User user = ConvertUtil.convert(userParam, User.class);
        System.out.println(user);
    }
}
