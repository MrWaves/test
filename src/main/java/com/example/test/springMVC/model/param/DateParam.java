package com.example.test.springMVC.model.param;

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
public class DateParam {
    /*
     * @DateTimeFormat(pattern='xxx') : 将传入的具有特定格式的日期字符串转换成Date对象
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
