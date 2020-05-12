package com.example.test.web.controller;

import com.example.test.generic.ConvertUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.example.test.web.controller
 * @Author: Mr.Waves
 * @Date: 2020-04-15 12:23
 * @Description:
 **/
@RestController
@RequestMapping("rest")
public class TestController {

    @GetMapping("test1")
    public String test1() {
        return "SUCCESS";
    }
}
