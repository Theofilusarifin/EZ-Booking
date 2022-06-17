/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Server implements Runnable {

    String chatClient, chatServer = "";
    ServerSocket ss;
    Thread t;
    Socket s;
    ArrayList<HandleSocket> clients = new ArrayList<HandleSocket>();

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.run();
        } catch (Exception e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                ss = new ServerSocket(6000);
                s = ss.accept();
                System.out.println("Masuk Server run");
                HandleSocket hs = new HandleSocket(this, s);
                hs.start();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
