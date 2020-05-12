package com.example.test.xml.demo;

import com.example.test.xml.XMLUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 12:57
 * @Description: XMLUtil测试类
 **/

public class springoxmTest {
    public static void main(String[] args) throws JAXBException, IOException {
        test2();
    }

    //object->xml 属性中内含Date类型和list集合
    private static void test1() throws JAXBException, IOException {
        Student stu1=new Student();
        stu1.setId("id1");
        stu1.setName("name1");
        stu1.setBirthday(new Date());

        Student stu2=new Student();
        stu2.setId("id1");
        stu2.setName("name1");
        stu2.setBirthday(new Date());

        StudentList list=new StudentList();
        list.setStudents(Arrays.asList(stu1,stu2));
        list.setSize(list.getStudents().size());
        String result = XMLUtil.convertToXml(list);
        System.out.println(result);
    }

    //xml->object
    private static void test2() throws JAXBException, IOException {
        String filePath = "D:\\workspace\\test\\src\\main\\resources\\static\\People.xml";
        StudentList list = XMLUtil.convertToObj(StudentList.class, filePath);
        System.out.println(list);
    }
}
