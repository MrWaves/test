package com.example.test.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-03 12:00
 * @Description:
 **/
@RestController
@RequestMapping("user")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public User save(User user) {

        if (userService.saveUser(user)) {
            System.out.printf("用户对象：%s 保存成功 \n",user);  // 用户对象：UserVO(id=1, name=张三) 保存成功
        }
        return user;
    }

    @GetMapping("getOne")
    public User getById(Integer id) {
        User user = userService.getUserById(id);
        // 当后端查不到数据时，返回一个空对象
        if (user == null) {
            user = new User();
        }
        return user;
    }
}
