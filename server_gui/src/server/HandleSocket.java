package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleSocket extends Thread {

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
    
//    Function untuk mengirimkan response ke client
    public void SendMessage(String s)
    {
        try {
            out.writeBytes(s + "\n");
        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CommandProcess(String command,String value){
        switch(command)
        {
//            Logic fitur reservation
            case "RESERVATION":
                System.out.println("Masuk");
                break;
//            Logic lain dibawah sini
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
//                Baca apapun yang masuk ke server
                String msg = in.readLine();
//                Pemisahan command disini
                String[] msgs = msg.split("//");
                
//                Command merupakan perintah apa yang masuk ke server 
                String command = msgs[0];
//                Value adalah string lain yang berada pada command untuk di proses
                String value = msgs[1];
                this.CommandProcess(command, value);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
