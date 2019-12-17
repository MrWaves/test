package com.example.test.springoxm;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 14:31
 * @Description:
 **/
@XmlRootElement(name = "People")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name"})
@Data
public class People {
    @XmlElement(name = "Id")
    private String id;
    @XmlElement(name = "Name")
    private String name;
}
