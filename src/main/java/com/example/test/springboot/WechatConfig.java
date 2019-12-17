package com.example.test.springboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: com.example.test.springboot
 * @Author: Mr.Waves
 * @Date: 2019/12/17 11:40
 * @Description:
 **/
@Configuration
@ConfigurationProperties(prefix = "wechat")
@Data
public class WechatConfig {
    private String token;
    private String appid;
}
