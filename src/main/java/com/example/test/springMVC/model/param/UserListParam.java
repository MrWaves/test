package com.example.test.springMVC.model.param;

import lombok.Data;
import java.util.List;

/**
 * @Package: com.example.test.springMVC.vo
 * @Author: Mr.Waves
 * @Date: 2019/12/16 12:01
 * @Description: springMVC 没办法把请求参数直接解析成 Collection或 Map，需要一层封装
 **/
@Data
public class UserListParam {
    private List<UserParam> list;
}
