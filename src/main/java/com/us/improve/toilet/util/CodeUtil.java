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

    /**
     * @param bytes
     * @return
     */
    public static int bytes2Int(byte[] bytes) {
        //如果不与0xff进行按位与操作，转换结果将出错，有兴趣的同学可以试一下。
        int int1 = bytes[0] & 0xff;
        int int2 = (bytes[1] & 0xff) << 8;
        int int3 = (bytes[2] & 0xff) << 16;
        int int4 = (bytes[3] & 0xff) << 24;

        return int1 | int2 | int3 | int4;
    }

}
