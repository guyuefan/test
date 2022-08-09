package com.uniubi.visitor.common.util;

import com.google.common.collect.Maps;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Map;

/**
 * @author zhaoyanbo
 * @date 2022/03/13
 */
public class RiskUtils {


    public static HttpEntity buildHttpRequest() {

        String date = Long.toString(Calendar.getInstance().getTime().getTime() / 1000);
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-wif-nonce", "QkjjtiLM2dCratiA");
        headers.set("x-wif-paasid", "smt-application");
        headers.set("x-wif-signature", sha265(date, "fTN2pfuisxTavbTuYVSsNJHetwq5bJvCQkjjtiLM2dCratiA"));
        headers.set("x-wif-timestamp", date);

        Map<String, String> body = Maps.newHashMap();
        body.put("appId", "NcApplication");
        body.put("paasHeader", "zdww");
        body.put("timestampHeader", date);
        body.put("nonceHeader", "123456789abcdefg");
        body.put("key", "3C502C97ABDA40D0A60FBEE50FAAD1DA");
        body.put("signatureHeader", sha265(date, "23y0ufFl5YxIyGrI8hWRUZmKkvtSjLQA" + body.get("nonceHeader")));
        return new HttpEntity<>(body, headers);

    }


    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    private static String sha265(String date, String secret) {

        String str = date + secret + date;
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr.toUpperCase();
    }

}
