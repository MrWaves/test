package com.example.test.web.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: com.example.test.web.config
 * @Author: Mr.Waves
 * @Date: 2020-04-15 12:46
 * @Description:
 **/
@Configuration
@ServletComponentScan(basePackages = "com.example.test.web.servlet")
public class ServletConfig {
}
