package com.example.test.java;


/**
 * @Package: com.example.test
 * @Author: Mr.Waves
 * @Date: 2019/4/6 11:37
 * @Description:
 **/
public class MethodParaTest {
    public static void main(String[] args) {
        test();
    }

    /*
     * 基本数据类型：值传递；引用型：引用传递
     */
    private static void test() {
        Student stu = new Student(1, "Jack");
        process(stu);
        System.out.println(stu);  // Student(id=2, name=Jack)
    }

    private static void process(Student stu) {
        stu.setId(2);
    }
}
