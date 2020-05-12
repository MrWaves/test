package com.example.test.aop.aspect;

import com.example.test.aop.anno.DoSomething;
import com.example.test.aop.util.SpringELParser;
import com.example.test.aop.User;
import com.example.test.aop.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-03 17:53
 * @Description: 自定义切面
 **/
@Component
@Aspect  // 用于增强原方法
@Slf4j
public class DoSomethingAspect {

    /*
     * pjp: 连接点，被修饰方法的封装
     * pointcut: 切点，目标连接点的集合
     * @Around(切点表达式): 增强方式的一种，环绕增强
     * 切点表达式：用于指定增强的作用范围，本例中指所有被@DoSomething修饰的方法
     */

    // 第一种实现方式：通过连接点逐步获取注解实例
//    @Around("@annotation(com.example.test.aop.anno.DoSomething)")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        // 通过连接点获取方法签名
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        // 通过签名获取方法
//        Method method = methodSignature.getMethod();
//        // 通过方法获取注解实例
//        DoSomething annotation = method.getAnnotation(DoSomething.class);
//        // 打印注解携带信息
//        System.out.println(annotation.key());
//        System.out.println(annotation.cacheName());
//        System.out.println(annotation.needLog());
//
//        System.out.println("---------------Before-------------------------");
//        Object result = pjp.proceed();
//        System.out.println("---------------After--------------------------");
//        return result;
//    }

    private UserRepository userRepository;

    @Autowired
    public DoSomethingAspect(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * 第二种实现方式：自动注入
     * @annotation: 匹配那些有指定注解的连接点
     */
    @Around("@annotation(anno)")
    public Object doAround(ProceedingJoinPoint pjp, DoSomething anno) throws Throwable {

        String id = getResult(anno.id(), pjp);
        boolean needLog = anno.needLog();

        // 模拟查询缓存
        User user = userRepository.findById(Integer.valueOf(id));
        if (user != null) {
            // 日志
            if (needLog) {
                log.info("从缓存中获取数据...");
            }
            return user;
        }
        // 缓存中没有
        if (needLog) {
            log.info("从数据库中获取数据...");
        }
        Object result = pjp.proceed();
        return result;
    }

    /*
     * 通过注解变量的字符串表达式和对应连接点，获取表达式运算结果
     */
    private String getResult(String expression, ProceedingJoinPoint pjp) {
        // 获取连接点的签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 通过签名获取连接点对应的方法
        Method method = methodSignature.getMethod();
        // 通过方法获取所有形参
        Parameter[] parameters = method.getParameters();
        // 遍历形参获取所有形参名
        String[] paraNames = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            paraNames[i] = parameters[i].getName();
        }
        // 调用SpringEL解析器，得出表达式结果
        return SpringELParser.getResult(expression, paraNames, pjp.getArgs());

    }

}
