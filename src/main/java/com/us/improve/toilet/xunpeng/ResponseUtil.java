package com.us.improve.toilet.xunpeng;

import com.us.improve.toilet.util.CodeUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName ResponseUtil
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/23 3:36 PM
 * @Version 1.0
 **/
public class ResponseUtil {

    public static void response(Socket socket, byte[] inBytes) {
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            byte[] outBytes = buildResponse(inBytes);

            dos.write(outBytes);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] buildResponse(byte[] inBytes) {
        if (ArrayUtils.isEmpty(inBytes)) {
            return null;
        }

        byte[] outBytes = new byte[12];
        System.arraycopy(inBytes, 0, outBytes, 0, inBytes.length);

        // 修改响应头
        outBytes[0] = 0x2A;

        // 调换本机地址和目标地址
        byte tmp;
        tmp = outBytes[1];
        outBytes[1] = outBytes[3];
        outBytes[3] = tmp;

        tmp = outBytes[2];
        outBytes[2] = outBytes[4];
        outBytes[4] = tmp;

        // 计算校验和
        byte[] subOutBytes = ArrayUtils.subarray(outBytes, 0, outBytes.length - 1);
        outBytes[11] = calCheckSum(subOutBytes);

        return outBytes;
    }

    private static byte calCheckSum(byte[] bytes) {
        String str = CodeUtil.byteArr2HexStr(bytes);
        String checkSumStr = calChecksum(str);
        return CodeUtil.hexToByte(checkSumStr);
    }

    private static String calChecksum(String data) {
        if (data == null || data.equals("")) {
            return "";
        }
        int total = 0;
        int len = data.length();
        int num = 0;
        while (num < len) {
            String s = data.substring(num, num + 2);
            //System.out.println(s);
            total += Integer.parseInt(s, 16);
            num = num + 2;
        }
        /**
         * 用256求余最大是255，即16进制的FF
         */
        int mod = total % 256;
        String hex = Integer.toHexString(mod);
        len = hex.length();
        // 如果不够校验位的长度，补0,这里用的是两位校验
        if (len < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

}
