package com.us.improve.toilet.xunpeng;

import com.us.improve.toilet.util.CodeUtil;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @ClassName DecodeUtil
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/23 3:24 PM
 * @Version 1.0
 **/
public class ResolveUtil {

    public static String resolveSensorAddr(byte[] bytes) {
        if (ArrayUtils.isEmpty(bytes)) {
            return null;
        }

        // 第4、5位字节
        byte[] subBytes = ArrayUtils.subarray(bytes, 3, 5);
        return CodeUtil.byteArr2HexStr(subBytes);
    }

    public static String resolveAction(byte[] bytes) {
        if (ArrayUtils.isEmpty(bytes)) {
            return null;
        }

        // 第10位字节
        String action = CodeUtil.byteToHexString(bytes[10]);
        if ("01".equals(action)) {
            return "进入";
        } else if ("02".equals(action)) {
            return "离开";
        } else {
            return "Unknown Action...";
        }
    }

}
