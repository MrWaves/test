package com.example.test.xml.demo;

import com.example.test.xml.demo.Student;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 14:36
 * @Description:
 **/
// 生成的xml文件根元素名为Students
@XmlRootElement(name = "Students")
// 用于指定由java对象生成xml文件时对java对象各字段的访问方式
// XmlAccessType.FIELD: java对象中的所有字段都要映射为xml文件中的元素或属性
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class StudentList {
    // 该字段在xml文件中为属性，对应的属性名为size
    @XmlAttribute(name = "size")
    private Integer size;

    // 该字段在xml文件中为元素，对应的元素名为Student
    @XmlElement(name = "Student")
    private List<Student> students;
}
