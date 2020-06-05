package com.cnzj.controller.wechat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckoutUtil {

    private static String token = "Javen";

    public CheckoutUtil() {
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        sort(arr);
        StringBuilder content = new StringBuilder();

        for(int i = 0; i < arr.length; ++i) {
            content.append(arr[i]);
        }

        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
        }

        content = null;
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";

        for(int i = 0; i < byteArray.length; ++i) {
            strDigest = strDigest + byteToHexStr(byteArray[i]);
        }

        return strDigest;
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[]{Digit[mByte >>> 4 & 15], Digit[mByte & 15]};
        String s = new String(tempArr);
        return s;
    }

    public static void sort(String[] a) {
        for(int i = 0; i < a.length - 1; ++i) {
            for(int j = i + 1; j < a.length; ++j) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

    }

}
