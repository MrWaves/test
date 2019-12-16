package com.example.test.springMVC.vo;

import lombok.Data;

import java.util.Map;

/**
 * @Package: com.example.test.springMVC.vo
 * @Author: Mr.Waves
 * @Date: 2019/12/16 14:12
 * @Description:
 **/
@Data
public class UserMapVO {
    Map<String,UserVO> users;
}
