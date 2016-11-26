package com.example.mylibrary.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Huang hai-sen on 2015/8/14.
 */
public class MD5Util {
    public static String md5(String str) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        //StringBuilder hex = new StringBuilder(hash.length * 2);//5.0����
        StringBuffer hex = new StringBuffer();
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static String md5_16(String str){
        return md5(str).substring(8,24);
    }
}
