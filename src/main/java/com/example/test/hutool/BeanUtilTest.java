package com.example.test.hutool;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.test.hutool.entity.User;

/**
 * @Package: com.example.test.hutool
 * @Author: Mr.Waves
 * @Date: 2020-04-23 13:42
 * @Description:
 **/
public class BeanUtilTest {
    public static void main(String[] args) {
        copyPropertiesTest();
    }

    private static void copyPropertiesTest() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Jack");
        user1.setGender(1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Tom");
        user2.setGender(0);

        BeanUtil.copyProperties(user2,user1, CopyOptions.create().ignoreError().ignoreNullValue());
        System.out.println(user1);
        System.out.println(user2);
    }
}
