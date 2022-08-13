package System;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ResourceBundle;

/* ClassName:
 *     Server
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public class Server extends Thread {

    private ResourceBundle service;
    private ResourceBundle database;
    private ResourceBundle net;

    private ServerSocket serverSocket = null;

    public Server() {
        service = ResourceBundle.getBundle("/properties/Service");
        database = ResourceBundle.getBundle("/properties/Database");
        net = ResourceBundle.getBundle("/properties/Net");
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(Integer.parseInt(net.getString("IP")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void JDBCStart() {

    }

    public ResourceBundle getService() {
        return service;
    }

    public ResourceBundle getDatabase() {
        return database;
    }

    public ResourceBundle getNet() {
        return net;
    }
}
