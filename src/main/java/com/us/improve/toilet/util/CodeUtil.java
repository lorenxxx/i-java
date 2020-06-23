package com.us.improve.toilet.util;

/**
 * @ClassName CodeUtil
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/23 3:26 PM
 * @Version 1.0
 **/
public class CodeUtil {

    public static String byteArr2HexStr(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static String byteToHexString(byte data) {
        StringBuilder sb = new StringBuilder();
        String strHex = Integer.toHexString(data);
        if (strHex.length() > 3) {
            sb.append(strHex.substring(6));
        } else {
            if (strHex.length() < 2) {
                sb.append("0" + strHex);
            } else {
                sb.append(strHex);
            }
        }

        return sb.toString();
    }

    public static byte hexToByte(String hex) {
        return (byte) Integer.parseInt(hex, 16);
    }

}
