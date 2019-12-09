package com.example.test.security;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Package: com.example.test.security
 * @Author: Mr.Waves
 * @Date: 2019/11/30 22:20
 * @Description: Base64测试
 **/
public class Base64Test {
    private static final String src="Hello World";

    public static void main(String[] args) throws IOException{
//      jdkBase64();
//        CCBase64();
        BCBase64();
    }

    private static void jdkBase64() throws IOException {
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());
        System.out.println(encode);
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] srcBytes = decoder.decodeBuffer(encode);
        System.out.println(new String(srcBytes));
    }

    private static void CCBase64() {
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println(new String(encodeBytes));
        byte[] src = Base64.decodeBase64(encodeBytes);
        System.out.println(new String(src));
    }

    private static void BCBase64() {
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        byte[] srcBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
        System.out.println(new String(encodeBytes));
        System.out.println(new String(srcBytes));
    }
}
