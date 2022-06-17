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
import model.User;

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
        String message;
        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {
                message = in.readLine();

                String[] messages = null;
                messages = message.split(";-;");

                String cmd = "";
                cmd = messages[0];

                User _user = new User();
                if (cmd.equals("LOGIN")) {
                    boolean tmp;
                    tmp = _user.CheckLogin(messages[1], messages[2]);
                    // kalau ketemu username yang sama
                    if (tmp) {
                        out.writeBytes("TRUE" + "\n");
                    } // kalau tidak ketemu username yang sama
                    else {
                        out.writeBytes("FALSE" + "\n");
                    }
                } else if (cmd.equals("ROLE")) {
                    String role = _user.CheckRole(messages[1], messages[2]);
                    out.writeBytes(role + "\n");
                } else if (cmd.equals("REGISTER")) {
                    String status = _user.Register(messages[1], messages[2], messages[3], messages[4]);
                    out.writeBytes(status + ";-;" + messages[1] + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error HandleSocket Constructor, Error: " + e);
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void sendChat(String tmp) {
        try {
            out.writeBytes(tmp + "\n");
        } catch (Exception e) {
            Logger.getLogger(Server.class
                    .getName()).log(Level.SEVERE, null, e);
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
