package com.example.test.java;

import com.example.test.jdbc.StuDTO;

/**
 * @Package: com.example.test
 * @Author: Mr.Waves
 * @Date: 2019/4/6 11:37
 * @Description: 基本数据类型：值传递；引用型：引用传递
 **/
public class MethodParaTest {
    public static void main(String[] args) {
        test();
    }

    //将引用对象当作参数传入方法进行操作时，会对该对象的属性产生影响
    private static void test() {
        StuDTO stuDTO = new StuDTO("123");
        process(stuDTO);
        System.out.println(stuDTO);
    }

    private static void process(StuDTO stuDTO) {
        stuDTO.setId(2l);
    }
}
