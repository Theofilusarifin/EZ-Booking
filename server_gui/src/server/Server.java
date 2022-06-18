package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{

    ServerSocket ss;
    Socket s;
    String message;
    ArrayList<HandleSocket> _clients;
    
    public Server() {
        try {
            ss = new ServerSocket(6000);
            _clients = new ArrayList<HandleSocket>();
            
            while(true)
            {
                s = ss.accept();
                HandleSocket hs = new HandleSocket(this, s);
                hs.start();
                _clients.add(hs);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
