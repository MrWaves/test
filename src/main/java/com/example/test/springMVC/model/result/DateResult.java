package com.example.test.springMVC.model.result;

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
public class DateResult {
    /*
     * @JsonFormat(pattern='xxx',timezone='GMT+8') : 将Date对象转换成具有特定格式的日期字符串
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  //
    private Date date;
}
