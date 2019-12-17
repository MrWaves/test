package com.example.test.springoxm;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 18:39
 * @Description: 对日期类型属性进行格式化
 **/
public class DateXmlAdapter extends XmlAdapter<String, Date> {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date unmarshal(String v) throws Exception {
        return FORMAT.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return FORMAT.format(v);
    }
}
