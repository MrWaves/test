package com.example.test.aop;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-03 11:52
 * @Description: 用户仓储类
 **/
@Repository
public class UserRepository {
    private final ConcurrentMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    /*
     *@Param: 用户信息
     *@Return:  保存成功返回true
     *@Description: 保存用户
     */
    public boolean save(User user) {
        // id从1开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return users.put(id,user) == null;
    }

    public User findById(Integer id) {
        return users.get(id);
    }
}
