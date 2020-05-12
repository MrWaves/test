package com.example.test.springMVC.model.param;

import lombok.Data;
import java.util.Map;

/**
 * @Package: com.example.test.springMVC.vo
 * @Author: Mr.Waves
 * @Date: 2019/12/16 14:12
 * @Description:
 **/
@Data
public class UserMapParam {
    Map<String, UserParam> map;
}
