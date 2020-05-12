package com.example.test.springMVC.util;

import com.example.test.springMVC.constant.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @Package: com.example.test.springMVC.common
 * @Author: Mr.Waves
 * @Date: 2020-04-28 16:47
 * @Description: string -> BaseEnum
 **/
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        if (!targetType.isEnum())
            throw new UnsupportedOperationException("只支持转换到枚举类型");
        return new StringToBaseEnumConverter<>(targetType);
    }

    private class StringToBaseEnumConverter<T extends BaseEnum> implements Converter<String, T> {
        private final Class<T> enumType;

        public StringToBaseEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String source) {
            for (T target : enumType.getEnumConstants()) {
                if (target.getValue().equals(Integer.valueOf(source)))
                    return target;
            }
            return null;
        }
    }

}
