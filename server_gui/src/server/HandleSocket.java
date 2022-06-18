package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Import model
import model.Bookings;
import model.Menu;
import model.Restaurant;
import model.User;


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
    public void SendMessage(String s) {
        try {
            out.writeBytes(s + "\n");
        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CommandProcess(String command, String value) throws IOException {
        String message;
        String[] messages = null;

        User _user = new User();

        switch (command) {
//            Logic fitur reservation
            case "GETDATARESTAURANT":
//                ArrayList<Object> restaurant = Res
                break;
            case "RESERVATION":
                System.out.println("Masuk");
                break;

//            Logic Fitur Login
            case "LOGIN":
                message = value;

                messages = message.split(";-;");

                boolean tmp;
                tmp = _user.CheckLogin(messages[0], messages[1]);
                // kalau ketemu username yang sama
                if (tmp) {
                    SendMessage("TRUE");
                } // kalau tidak ketemu username yang sama
                else {
                    SendMessage("FALSE");
                }
                break;

//            Cari Role Buat Login
            case "ROLE":
                message = value;

                messages = message.split(";-;");

                String role = _user.CheckRole(messages[0], messages[1]);
                SendMessage(role);
                break;

//            Ya Register
            case "REGISTER":
                message = value;

                messages = message.split(";-;");
                
                String status = _user.Register(messages[0], messages[1], messages[2], messages[3]);
                SendMessage(status + ";-;" + messages[0]);
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
