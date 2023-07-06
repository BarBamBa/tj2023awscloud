package com.tj.edu.practice2.spring_ioc_practice;

import com.tj.edu.practice2.spring_ioc_practice.IEncoder;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;

@Component
public class UrlEncoder implements IEncoder {

    @Override
    public String encodeString(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] encodeByte(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8").getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}