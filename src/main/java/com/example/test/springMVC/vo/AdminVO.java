package com.example.test.springMVC.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 11:03
 * @Description:
 **/
//xml根节点标签<admin></admin>
@Data
@XmlRootElement(name = "admin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","age"})
public class AdminVO {
    @XmlElement(name = "Age")
    private Integer age;
    @XmlElement(name = "Name")
    private String name;


}
