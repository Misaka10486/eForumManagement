package System;

import Service.Request.Request;
import Service.Response.Response;
import Service.Service.Service;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

/* ClassName:
 *     ClientResponse
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public class ClientResponse extends Thread {

    private final Socket clientSocket;
    private final Server server;

    public ClientResponse(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    void handle() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            System.out.println("进入handle！");
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            //计算预期接受字节数
            int size = 0;
            for (int i = 0; i < 4; i++) {
                size += Math.pow(0X100, i) * inputStream.read();
            }
            System.out.println("预计接收字节数: " + size);

            //接收数据
            byte[] bytes = new byte[size];
            System.out.println("开始读取数据！");
            int b, i = 0;
            while (-1 != (b = inputStream.read())) {
                bytes[i++] = (byte) b;
            }
            System.out.println("总共传输字节数：" + i);
            if (i != size) {
                System.out.println("预计传输字节数与实际传输字节数不一致！");
                return;
            }

            //将接收数据转换为对象
            System.out.println("读取完成，开始转换为对象！");
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            //根据请求进行服务
            var response = serve((Request) objectInputStream.readObject());
            System.out.println("事务处理完毕，开始返回结果！");

            //序列化对象
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(response);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();

            //传送字节数大小
            System.out.println("开始传送预期传送字节数！");
            for (int j = 0; j < 4; ++j) {
                outputStream.write(bytes.length / ((int) Math.pow(0X100, j)) % 0X100);
            }

            //传送数据
            System.out.println("开始传送数据！");
            for (byte y :
                    bytes) {
                outputStream.write(y);
            }
            System.out.println("传送完毕！");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                byteArrayOutputStream.close();
                if (null != objectOutputStream) {
                    objectOutputStream.close();
                }
                if (null != objectInputStream) {
                    objectInputStream.close();
                }
                if (null != byteArrayInputStream) {
                    byteArrayInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Response serve(Request request) {
        try {
            var serviceType = Class.forName(server.getService().getString(request.requestType));
            Class<?>[] parameterTypes = { Request.class };
            var serviceConstructor = serviceType.getDeclaredConstructor(parameterTypes);
            return ((Service) (serviceConstructor.newInstance(request))).handle(request);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
