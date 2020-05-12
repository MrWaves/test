package com.example.test.aop;

import com.example.test.aop.anno.DoSomething;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-02 18:44
 * @Description: 用户服务实现类
 **/

@Service
@DoSomething(id = "class-id",cacheName = "class-cacheName",needLog = true)
public class UserServiceImpl {
    private static final String CACHE_NAME = "USER";
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @DoSomething(id = "#id",cacheName = CACHE_NAME,needLog = true)
    public User getUserById(Integer id) {
        System.out.println("--------------------------------------");
        return userRepository.findById(id);
    }

    public boolean saveUser(User user) {
        return userRepository.save(user);
    }
}
