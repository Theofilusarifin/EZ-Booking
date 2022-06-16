/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jabeshnehemiah
 */
public class HandleSocket extends Thread implements Runnable {

    private Server parent;
    private Socket client;
    private DataOutputStream out;
    private BufferedReader in;

    public HandleSocket(Server parent, Socket client) {
        this.parent = parent;
        this.client = client;
        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sendChat(String tmp) {
        try {
            out.writeBytes(tmp + "\n");
        } catch (Exception e) {
            Logger.getLogger(Server.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = in.readLine();
                String[] msgs = msg.split("//");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
