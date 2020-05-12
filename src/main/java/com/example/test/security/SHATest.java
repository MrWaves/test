//package com.example.test.security;
//
//import org.apache.commons.codec.binary.Hex;
//import org.apache.commons.codec.cli.Digest;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.Security;
//
///**
// * @Package: com.example.test.security
// * @Author: Mr.Waves
// * @Date: 2019/12/9 20:32
// * @Description: 测试sha
// **/
//public class SHATest {
//    private static final String src = "hello SHA";
//
//    public static void main(String[] args) {
//        jdkSHA1();
//        bcSHA1();
//        providerSHA256();
//    }
//
//    private static void jdkSHA1() {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA");
//            byte[] digestBytes = md.digest(src.getBytes());
//            String digest = Hex.encodeHexString(digestBytes);
//            System.out.println(digest);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void bcSHA1() {
//        Digest digest = new SHA1Digest();
//        digest.update(src.getBytes(), 0, src.getBytes().length);
//        byte[] digestByets = new byte[digest.getDigestSize()];
//        digest.doFinal(digestByets, 0);
//        String digestStr = Hex.toHexString(digestByets);
//        System.out.println(digestStr);
//    }
//
//    private static void providerSHA256() {
//        Security.addProvider(new BouncyCastleProvider());
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA256");
//            byte[] digestBytes = md.digest(src.getBytes());
//            System.out.println(Hex.toHexString(digestBytes));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
