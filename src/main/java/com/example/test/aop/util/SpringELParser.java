package com.example.test.aop.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Package: com.example.test.aop
 * @Author: Mr.Waves
 * @Date: 2020-02-04 18:28
 * @Description: SpringEL表达式解析器
 **/
public class SpringELParser {
    private static final ExpressionParser parser = new SpelExpressionParser();

    /*
     * expression: 字符串表达式
     * paraNames: 形参名集合
     * args: 实参集合
     */
    // 通过字符串表达式和连接点数据(形参和实参)获取表达式运算结果
    public static String getResult(String expression, String[] paraNames, Object[] args) {
        // 第一步：将字符串表达式解析为SpringEL表达式
        Expression exp = parser.parseExpression(expression);
        // 第二步：创建“上下文”，将形参名和对应实参以键值对的方式存入其中
        EvaluationContext context = new StandardEvaluationContext();
        if (args.length <= 0) {
            return null;
        }
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paraNames[i],args[i]);
        }
        // 第三步：根据上下文中的数据和表达式返回运算结果
        return exp.getValue(context,String.class);
    }
}
