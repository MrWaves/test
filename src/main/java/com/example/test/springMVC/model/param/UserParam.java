package com.example.test.springMVC.model.param;

import com.example.test.springMVC.constant.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @Package: com.example.test.springMVC.model.param
 * @Author: Mr.Waves
 * @Date: 2020-04-20 11:01
 * @Description:
 **/
@Data
@NoArgsConstructor
public class UserParam {
    private Integer age;
    private String name;
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //请求参数日期 String->Date
    private Date createTime;
}
