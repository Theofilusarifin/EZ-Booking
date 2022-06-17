/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Server implements Runnable {

    String chatClient, chatServer = "";
    Socket s;
    ServerSocket ss;
    Thread t;
    ArrayList<HandleSocket> clients = new ArrayList<HandleSocket>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
