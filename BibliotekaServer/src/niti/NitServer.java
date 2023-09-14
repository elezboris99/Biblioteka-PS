/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Elez
 */
public class NitServer extends Thread {

    private ServerSocket serverSocket;

    public NitServer() {
        try {
            serverSocket = new ServerSocket(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                System.out.println("Cekanje klijenta...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                NitKlijent th = new NitKlijent(socket);
                th.start();
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

}
