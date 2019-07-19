package com.atcong.Util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class passwordDigest {
    public static String passwordTransfer(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64.Encoder base64Encoder = Base64.getEncoder();
        return base64Encoder.encodeToString(md5.digest(password.getBytes("utf-8")));
    }

    public static boolean comparePassword(String password,String dataBasePassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (passwordTransfer(password).equals(dataBasePassword)) {
            return true;
        }
        else {
            return false;
        }
    }
}
