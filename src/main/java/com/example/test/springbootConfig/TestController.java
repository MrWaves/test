package com.example.test.springbootConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.example.test.springbootConfig
 * @Author: Mr.Waves
 * @Date: 2019/12/17 11:17
 * @Description: 从配置文件中读取配置信息
 **/
@RestController
public class TestController {

    @Value("${wechat.token}")
    private  String token;

    private final WechatConfig wechatConfig;

    @Autowired
    public TestController(WechatConfig wechatConfig) {
        this.wechatConfig = wechatConfig;
    }

    /*
     * 借助@Value("${...}")读取配置信息
     */
    @GetMapping("token")
    public String token() {
        System.out.println(token);
        return token;
    }

    /*
     * 借助@ConfigurationProperties(prefix = "...")将配置信息封装成一个配置类
     */
    @GetMapping("wechat")
    public String wechat() {
        System.out.println(wechatConfig.toString());
        return wechatConfig.toString();
    }


}
