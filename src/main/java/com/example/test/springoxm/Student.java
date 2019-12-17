package com.example.test.springoxm;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 14:34
 * @Description:
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","name","birthday"})
@Data
public class Student {
    @XmlElement(name = "Id")
    private String id;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Birthday")
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    private Date birthday;
}
