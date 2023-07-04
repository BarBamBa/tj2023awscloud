package com.tj.edu.practice2.spring_ioc;

import com.tj.edu.practice2.ioc.IEncoder;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Base64Encoder implements IEncoder {

    @Override
    public String encodeString(String message) {
        // Base64 인코딩 ///////////////////////////////////////////////////
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public byte[] encodeByte(String message) {
        // Base64 인코딩 ///////////////////////////////////////////////////
        Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(message.getBytes());

        return encodedBytes;
    }
}
