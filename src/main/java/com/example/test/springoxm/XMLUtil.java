package com.example.test.springoxm;

import lombok.Cleanup;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @Package: com.example.test.springoxm
 * @Author: Mr.Waves
 * @Date: 2019/12/17 14:42
 * @Description: JAXB工具类
 **/

public class XMLUtil {

    //将对象转换成xml字符串
    public static String convertToXml(Object obj) throws JAXBException ,IOException{
        //字符串流
        @Cleanup StringWriter sw=new StringWriter();
        Marshaller marshaller = getMarshaller(obj);
        marshaller.marshal(obj,sw);

        return sw.toString();
    }

    //将对象转换成xml文件
    public static void convertToXml(Object obj, String filePath) throws IOException, JAXBException {
        @Cleanup FileWriter fw = new FileWriter(filePath);
        Marshaller marshaller = getMarshaller(obj);
        marshaller.marshal(obj,fw);
    }

    //将xml字符串转换成对象
    //泛型方法，clazz为T的Class对象
    public static <T> T convertToObj(String xmlStr,Class<T> clazz) throws JAXBException {
        Unmarshaller unmarshaller = getUnmarshaller(clazz);
        @Cleanup StringReader sr = new StringReader(xmlStr);
        T  result= (T)unmarshaller.unmarshal(sr);
        return result;
    }

    //将xml文件转换成对象
    public static <T> T convertToObj( Class<T> clazz,String filePath) throws JAXBException, FileNotFoundException,IOException {
        Unmarshaller unmarshaller = getUnmarshaller(clazz);
        @Cleanup FileReader fr = new FileReader(filePath);
        T result=(T)unmarshaller.unmarshal(fr);
        return result;
    }

    //创建编组器
    private static Marshaller getMarshaller(Object obj) throws JAXBException {
        //创建编组器
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        //编码格式
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
        //是否格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        return marshaller;
    }

    //创建解组器
    private static Unmarshaller getUnmarshaller(Class clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller;
    }
}
