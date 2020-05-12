package com.example.test.concurrency;

import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: cn.stylefeng.guns.modular.fabric.util
 * @Author: Mr.Waves
 * @Date: 2020-04-22 17:56
 * @Description:
 **/
@UtilityClass
public class CodeUtil {
    /*
     * 单据前缀
     */
    private final String ORDER_PREFIX = "ORD";
    private final String DELIVERY_PREFIX = "DEL";

    private AtomicInteger ORDER_COUNT;
    private AtomicInteger DELIVERY_COUNT;


    private String date;

    private String getDate() {
        return LocalDate.now(ZoneId.of("Asia/Shanghai")).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }


    public String generateOrderCode() {
        StringBuilder builder = new StringBuilder(ORDER_PREFIX);
        String number = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        builder.append(number);
        return builder.toString();
    }

    public String generateDeliveryCode() {
        StringBuilder builder = new StringBuilder(DELIVERY_PREFIX);
        String number = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        builder.append(number);
        return builder.toString();
    }
}
