package com.example.test.springoxm;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 14:36
 * @Description:
 **/
@XmlRootElement(name = "Students")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class StudentList {
    @XmlAttribute(name = "size")
    private Integer size;

    @XmlElement(name = "Student")
    private List<Student> students;
}
