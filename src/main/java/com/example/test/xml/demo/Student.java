package com.example.test.xml.demo;

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
// 用于对java对象生成的xml元素进行排序
@XmlType(propOrder = {"id","name","birthday"})
@Data
public class Student {
    // 该字段在xml文件中为元素，对应的属性名为Id
    @XmlElement(name = "Id")
    private String id;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Birthday")
    // 在生成xml文本时对日期进行格式化
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    private Date birthday;
}
