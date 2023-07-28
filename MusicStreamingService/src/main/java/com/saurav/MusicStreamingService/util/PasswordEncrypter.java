package com.saurav.MusicStreamingService.util;
import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public final class PasswordEncrypter {
    public static String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(userPassword.getBytes());
        byte[] digested = messageDigest.digest();
        return DatatypeConverter.printHexBinary(digested);
    }
}
