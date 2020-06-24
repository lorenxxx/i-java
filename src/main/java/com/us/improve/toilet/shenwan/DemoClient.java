package com.us.improve.toilet.shenwan;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName DemoClient
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/24 11:26 AM
 * @Version 1.0
 **/
public class DemoClient {

    private static final String SERVER_URI = "wss://toilet.emscloud.com.cn:8000/";

    public static WebSocketClient client;

    public static void main(String[] args) {
        try {
            client = new WebSocketClient(new URI(SERVER_URI)) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    client.send("{\"CorpName\":\"sina\",\"applicationID\":8}");
                    System.out.println("WebSocket连接[" + SERVER_URI +"]建立成功...");
                }

                @Override
                public void onMessage(String msg) {
                    //System.out.println(msg);
                    resolveMsg(msg);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("websocket connection close");
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        client.connect();
    }

    private static void resolveMsg(String msg) {
        if (StringUtils.isBlank(msg)) {
            return;
        }

        JSONObject jsonObject = parseJsonObject(msg);
        if (jsonObject == null) {
            return;
        }

        String id = jsonObject.getString("devEUI");

        if ("index".equals(id)) {
            // ignore
        } else if ("list".equals(id)) {
            // ignore
        } else if (id.length() == 16) {
            String data = jsonObject.getString("data");
            if (StringUtils.endsWithIgnoreCase("00", data.substring(4, 6))) {
                System.out.println("传感器[" + id + "] -> 进入");
            } else if (StringUtils.endsWithIgnoreCase("03", data.substring(4, 6))) {
                System.out.println("传感器[" + id + "] -> 离开");
            }
        } else {
            // ignore
        }
    }

    private static JSONObject parseJsonObject(String content) {
        try {
            return JSONObject.parseObject(content);
        } catch (Exception e) {
            return null;
        }
    }

}
