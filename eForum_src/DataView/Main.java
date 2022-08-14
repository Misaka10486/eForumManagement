package DataView;

import java.net.SocketTimeoutException;

import DataModel.User.User;
import DataTransfer.ClientRequest;
import DataTransfer.RequestException;
import Service.Request.LogInRequest;
import Service.Request.Request;
import Service.Response.LogInResponse;

public class Main {
    public static void main(String[] args) {
        // Process process = new Process();
        // process.start();

        User user = new User("jack", "admin");
        Request request = new LogInRequest(user);

        try {
            ClientRequest clientRequest = new ClientRequest();
            LogInResponse response = (LogInResponse) clientRequest.request(request);
            System.out.println(response.success ? "登录成功！" : "登录失败！");
        } catch (RequestException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}


















