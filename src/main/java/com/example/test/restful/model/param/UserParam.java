package com.example.test.restful.model.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Package: com.example.test.restful.vo
 * @Author: Mr.Waves
 * @Date: 2020-02-15 18:17
 * @Description:
 **/
@Data
public class UserParam {
    private Long id;
    @NotBlank(message = "用户名不能为空")
    @Length(max = 30,message = "您的用户名过长")
    private String name;
}
