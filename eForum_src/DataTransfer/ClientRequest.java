package DataTransfer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ResourceBundle;

import Service.Request.Request;
import Service.Response.Response;

public class ClientRequest {

    private final ResourceBundle resourceBundle;
    private final Socket clientSocket;

    public ClientRequest() throws RequestException {
        this.resourceBundle = ResourceBundle.getBundle("\\properties\\Net");
        try {
            this.clientSocket = new Socket(resourceBundle.getString("IP"), Integer.parseInt(resourceBundle.getString("port")));
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            throw new RequestException("连接请求出错！");
        }
    }

    //调用request函数进行服务请求
    public Response request(Request request) throws RequestException {
        try {
            return transfer(request, clientSocket.getOutputStream(), clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        throw new RequestException("连接请求出错！");
    }

    private Response transfer(Request request, OutputStream outputStream, InputStream inputStream) throws RequestException {
        try {
            byte[] bytes = toBytes(request);

            transferSize(outputStream, bytes.length);

            transferData(outputStream, bytes);

            bytes = new byte[getSize(inputStream)];

            readBytes(inputStream, bytes);

            return (Response) toObject(bytes);
        } catch (TransferException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        throw new RequestException("连接请求出错！");
    }

    //计算预期接收字节数
    private int getSize(InputStream inputStream) throws TransferException {
        int size = 0;
        try {
            for (int i = 0; i < 4; i++) {
                size += Math.pow(0X100, i) * inputStream.read();
            }
            return size;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new TransferException("计算传输数据量出错！");
    }

    //接收数据
    private void readBytes(InputStream inputStream, byte[] bytes) throws TransferException {
        System.out.println("开始接收数据！");
        int b, i = 0;
        try {
            while (-1 != (b = inputStream.read())) {
                bytes[i++] = (byte) b;
            }
            System.out.println("总共接收数据量：" + i);
            if (bytes.length == i) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new TransferException("预计接收数据量与实际接收数据量不一致！");
    }

    //将接收的数据解析为对象
    private Object toObject(byte[] bytes) throws TransferException {
        System.out.println("开始解析对象！");
        ObjectInputStream objectInputStream = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes); //ByteArrayInputStream不需要手动关闭
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream); //利用ByteArrayInputStream构造ObjectInputStream
            return objectInputStream.readObject(); //ObjectInputStream负责解析对象
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != objectInputStream) {
                    objectInputStream.close(); //关闭流释放资源
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new TransferException("反序列化出错！");
    }

    //将传送的对象序列化为数据
    private byte[] toBytes(Object object) throws TransferException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //ByteArrayInputStream不需要手动关闭
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream); //利用ByteArrayOutputStream构造ObjectOutputStream
            objectOutputStream.writeObject(object); //利用ObjectOutputStream序列化对象
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != objectOutputStream) {
                    objectOutputStream.close(); //关闭流释放资源
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new TransferException("序列化出错！");
    }

    //传送预期传送数据量
    private void transferSize(OutputStream outputStream, int size) throws TransferException {
        System.out.println("开始传送预期传送数据量！");
        try {
            for (int j = 0; j < 4; ++j) {
                outputStream.write(size / ((int) Math.pow(0X100, j)) % 0X100);
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new TransferException("传送预期传送数据量出错！");
    }

    //传送数据
    private void transferData(OutputStream outputStream, byte[] bytes) throws TransferException {
        System.out.println("开始传送数据！");
        try {
            for (byte y :
                    bytes) {
                outputStream.write(y);
            }
            outputStream.flush();
            clientSocket.shutdownOutput();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new TransferException("传送数据出错！");
    }
}