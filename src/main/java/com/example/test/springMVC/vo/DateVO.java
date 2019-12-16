package com.example.test.springMVC.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Package: com.example.test.springMVC.vo
 * @Author: Mr.Waves
 * @Date: 2019/12/16 19:40
 * @Description:
 **/
@Data
public class DateVO {
    //请求参数转换类型 String->Date
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //结果参数转换类型 Date->String
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;
}
