package com.us.improve.toilet.xunpeng;

import com.us.improve.toilet.util.CodeUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName DecodeUtil
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/23 3:24 PM
 * @Version 1.0
 **/
public class ResolveUtil {

    public static String resolveFrameHeader(byte[] inBytes) {
        if (ArrayUtils.isEmpty(inBytes)) {
            return null;
        }

        byte[] dateTypeBytes = ArrayUtils.subarray(inBytes, 0, 1);
        return CodeUtil.byteArr2HexStr(dateTypeBytes);
    }

    public static String resolveFrameHeader(String inHexStr) {
        if (StringUtils.isBlank(inHexStr)) {
            return null;
        }

        return inHexStr.substring(HexDataIndexConstants.FRAME_HEADER_START_INDEX, HexDataIndexConstants.FRAME_HEADER_END_INDEX + 1);
    }

    public static String resolveSensorAddr(byte[] inBytes) {
        if (ArrayUtils.isEmpty(inBytes)) {
            return null;
        }

        // 第4、5位字节
        byte[] sensorBytes = ArrayUtils.subarray(inBytes, 3, 5);
        return CodeUtil.byteArr2HexStr(sensorBytes);
    }

    public static String resolveSensorAddr(String inHexStr) {
        if (StringUtils.isBlank(inHexStr)) {
            return null;
        }

        return inHexStr.substring(HexDataIndexConstants.LOCAL_ADDRESS_START_INDEX, HexDataIndexConstants.LOCAL_ADDRESS_END_INDEX + 1);
    }

    public static String resolveEvent(byte[] inBytes) {
        if (ArrayUtils.isEmpty(inBytes)) {
            return null;
        }

        // 第10位字节
        String event = CodeUtil.byteToHexString(inBytes[10]);
        if ("01".equals(event)) {
            return "进入";
        } else if ("02".equals(event)) {
            return "离开";
        } else {
            return "Unknown Action...";
        }
    }

    public static String resolveEvent(String inHexStr) {
        if (StringUtils.isBlank(inHexStr)) {
            return null;
        }

        String event = inHexStr.substring(HexDataIndexConstants.EVENT_START_INDEX, HexDataIndexConstants.EVENT_END_INDEX + 1);
        if ("01".equals(event)) {
            return "进入";
        } else if ("02".equals(event)) {
            return "离开";
        } else {
            return "Unknown Action...";
        }
    }

}
