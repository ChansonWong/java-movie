package com.superatom.javamovie.utils;


import com.superatom.javamovie.model.RequestParam;

import java.security.MessageDigest;
import java.util.List;

public class Md5Util {

    private static final String slat = "#^%$&^@&)_+&%<<>?<,.asdaaaAAbefwfnnkpp{poQBEaNw>,LIipo";

    public static String getMd5(List<RequestParam> paramList){
        String dataStr = genParamStr(paramList);
        dataStr = dataStr + slat;
        MessageDigest m = null;
        String result = "";
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();

            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    private static String genParamStr(List<RequestParam> paramList){
        StringBuffer buffer = new StringBuffer();
        for (RequestParam param : paramList){
            buffer.append(param.getKey()).append(param.getValue());
        }

        return buffer.toString();
    }
}
