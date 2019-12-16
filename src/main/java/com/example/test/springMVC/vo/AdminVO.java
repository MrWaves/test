package com.example.test.springMVC.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Package: com.example.test.springMVC
 * @Author: Mr.Waves
 * @Date: 2019/12/16 11:03
 * @Description:
 **/
//xml根节点标签<admin></admin>
@XmlRootElement(name = "admin")
public class AdminVO {
    private Integer age;
    private String name;

    @XmlElement(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdminVO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}
