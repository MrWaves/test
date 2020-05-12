package com.example.test.springMVC.model.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.test.springMVC.constant.enums.Gender;
import com.example.test.springMVC.model.param.ContactParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 10:50
 * @Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserResult {
    private Integer age;
    private String name;

    /*
     *
     */
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private Gender gender;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private ContactParam contact;

}
