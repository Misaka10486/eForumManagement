package DataTransfer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import DataModel.User.User;

public class ObjectTransfer {

    public String IP;

    public static void main(String[] args) {
        User user = new User("name", "password");
        boolean f = (Boolean)transfer(user);
        System.out.println(f ? "登录成功！" : "登录失败！");
    }

    public static Object transfer(Object object) {
        Socket socket = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            //序列化对象
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            byte[] bytes = byteArrayOutputStream.toByteArray();

            //建立TCP连接
            socket = new Socket("localhost", 8888);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            //传送字节数大小
            for (int i = 0; i < 4; ++i) {
                outputStream.write(bytes.length / ((int) Math.pow(0X100, i)) % 0X100);
            }

            //传送数据
            for (byte b : bytes) {
                outputStream.write(b);
            }
            outputStream.flush();
            socket.shutdownOutput();

            //计算预期接收字节数
            int size = 0;
            for (int i = 0; i < 4; i++) {
                size += Math.pow(0X100, i) * inputStream.read();
            }
            System.out.println("预计接收字节数: " + size);
            
            //接收数据
            bytes = new byte[size];
            System.out.println("开始读取数据！");
            int b, i = 0;
            while (-1 != (b = inputStream.read())) {
                bytes[i++] = (byte) b;
            }
            System.out.println("总共传输字节数：" + i);
            if (i != size) {
                System.out.println("预计传输字节数与实际传输字节数不一致！");
                return null;
            }

            //将接收数据转换为对象
            System.out.println("读取完成，开始转换为对象！");
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != socket) {
                    socket.close();
                }
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
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return null;
    }
}