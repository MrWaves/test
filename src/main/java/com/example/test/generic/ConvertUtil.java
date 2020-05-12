package com.example.test.generic;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.SneakyThrows;

/**
 * @Package: cn.stylefeng.guns.modular.fabric.util
 * @Author: Mr.Waves
 * @Date: 2020-04-15 10:54
 * @Description:
 **/
public class ConvertUtil {

    @SneakyThrows
    public static <S, T> T convert(S source, Class<T> clz) {
        T target = clz.newInstance();
        BeanUtil.copyProperties(source, target, CopyOptions.create().ignoreNullValue().ignoreError());
        return target;
    }
}
