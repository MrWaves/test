package com.example.test.restful.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.test.restful.entity.User;
import com.example.test.restful.model.param.UserParam;
import com.example.test.restful.model.result.BaseResponse;
import com.example.test.restful.model.result.UserResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @Package: com.example.test.restful
 * @Author: Mr.Waves
 * @Date: 2020-02-15 18:15
 * @Description: restful风格的接口
 **/
@RestController
@RequestMapping("api")
public class UserController {
    /*
     * get one
     */
    @GetMapping("user/{id}")
    public BaseResponse<User> getOne(@PathVariable("id") Long id) {
        // mock select
        UserResult userResult = new UserResult();
        User user = new User();
        user.setId(id);
        user.setName("张三");
        user.setStatus(0);
        BeanUtil.copyProperties(user,userResult, CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase());
        return new BaseResponse(200,"查询成功！",user);
    }

    /*
     * add
     */
    @PostMapping("user")
    public BaseResponse<UserResult> insertUser(@RequestBody @Valid UserParam userParam) {
        // mock
        UserResult userResult = new UserResult();
        userParam.setId(345L);
        BeanUtil.copyProperties(userParam,userResult, CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase());
        return new BaseResponse<>(200,"插入成功！",userResult);
    }

    /*
     * update
     */
    @PutMapping("user")
    public BaseResponse<UserResult> updateUser(@RequestBody UserParam userParam) {
        // mock
        UserResult userResult = new UserResult();
        BeanUtil.copyProperties(userParam,userResult, CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase());
        return new BaseResponse<>(200,"更新成功！",userResult);
    }

    /*
     * delete
     */
    @DeleteMapping("user/{id}")
    public BaseResponse deleteUserById(@PathVariable("id") Long id) {
        // mock
        return new BaseResponse(200,"删除成功！");
    }

    /*
     * page
     */
    @GetMapping("users")
    public BaseResponse getPage(UserParam param) {
        // mock
        return new BaseResponse(200, "查询成功!", param);
    }
}
