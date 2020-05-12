package com.example.test.collection;

import com.example.test.collection.entity.User;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: bo.wang
 * @Date: 2017/12/12
 * @Project: test
 */
public class SetTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Set<User> users = new HashSet<>();
        users.add(new User(1L,"Jack"));
        users.add(new User(1L,"Jack"));
        System.out.println(users.toString());   //[User(id=1, name=Jack)]
    }
}
