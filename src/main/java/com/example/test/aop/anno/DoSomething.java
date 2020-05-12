package com.example.test.aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-02 18:26
 * @Description: 自定义注解
 **/
@Retention(RetentionPolicy.RUNTIME) // 注解生效的生命周期
@Target({ElementType.TYPE,ElementType.METHOD})  // 指定注解的修饰对象类型
public @interface DoSomething {
    String id() ;  // 关于id的运算表达式
    String cacheName() ;  // 关于cacheName的运算表达式
    boolean needLog() default false;  // 关于needLog的运算表达式
}
