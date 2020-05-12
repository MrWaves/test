package com.example.test.springMVC.model.param;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 11:03
 * @Description:
 **/
@Data
// xml根节点标签<admin></admin>
@XmlRootElement(name = "admin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","age"})
public class AdminParam {
    @XmlElement(name = "age")
    private Integer age;
    @XmlElement(name = "name")
    private String name;


}
