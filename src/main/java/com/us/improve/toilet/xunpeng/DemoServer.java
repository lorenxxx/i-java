package com.us.improve.toilet.xunpeng;

import com.us.improve.toilet.util.CodeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @ClassName DemoServer
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/23 3:59 PM
 * @Version 1.0
 **/
public class DemoServer implements Runnable {

    private static final int PORT = 5020;

    private ServerSocket serverSocket;

    public DemoServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务启动，等待远程连接，端口号为: " + serverSocket.getLocalPort());

                Socket socket = serverSocket.accept();
                System.out.println("远程主机连接成功，地址：" + socket.getRemoteSocketAddress());
                System.out.println("\n\n\n");

                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                DataInputStream dis = new DataInputStream(bis);

                byte[] inBytes = new byte[12];
                while (dis.read(inBytes) != -1) {
                    String inHexStr = CodeUtil.byteArr2HexStr(inBytes);
                    System.out.println("收到数据: " + inHexStr);

                    String frameHeader = ResolveUtil.resolveFrameHeader(inHexStr);
                    System.out.println("数据类型: " + frameHeader);

                    // 只对"3A"类型的帧头做响应
                    if (StringUtils.equalsIgnoreCase(HexDataConstants.IN_AND_OUT_DATA_FRAME_HEADER, frameHeader)) {
                        // 进行应答(200ms内不进行应答会收到16条重复数据)
                        ResponseUtil.response(socket, inBytes);

                        // 业务处理
                        String sensorAddr = ResolveUtil.resolveSensorAddr(inHexStr);
                        String action = ResolveUtil.resolveEvent(inHexStr);

                        System.out.println("传感器本机地址: " + sensorAddr);
                        System.out.println("传感器事件: " + action);
                    } else {
                        System.out.println("Unknown Data, ignore...");
                    }

                    System.out.println();
                }
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new DemoServer());
            thread.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
