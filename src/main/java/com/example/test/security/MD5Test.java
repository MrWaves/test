package com.example.test.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @Package: com.example.test.security
 * @Author: Mr.Waves
 * @Date: 2019/12/9 11:42
 * @Description: 消息摘要测试
 **/
public class MD5Test {
    private static final String src = "Hello MD5";

    public static void main(String[] args) {
        md5Test();
        md5CC();
        md2Test();
        md4Test();
        md4Test2();
    }

    private static void md5Test() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(src.getBytes());
            String digest = Hex.toHexString(md5Bytes);  //只有转为16进制才能输出
            System.out.println(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void md2Test() {
        try {
            MessageDigest md2 = MessageDigest.getInstance("MD2");
            byte[] md2Bytes = md2.digest(src.getBytes());
            String digest = Hex.toHexString(md2Bytes);
            System.out.println(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void md4Test() {
        Digest digest = new MD4Digest();
        digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] md2Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md2Bytes, 0);
        System.out.println(Hex.toHexString(md2Bytes));
    }

    //将BC加入JDK安全提供者列表，MD4就可以通过JDK使用了
    private static void md4Test2() {
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md4 = MessageDigest.getInstance("MD4");
            byte[] md4Bytes = md4.digest(src.getBytes());
            String digest = Hex.toHexString(md4Bytes);
            System.out.println(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void md5CC() {
        String digest = DigestUtils.md5Hex(src);
        System.out.println(digest);
    }

}
