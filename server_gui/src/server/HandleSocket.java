package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

//Import model
import model.Bookings;
import model.Menu;
import model.Preorder;
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
            System.out.println("Error di handdle socket constructor" + e);
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
        try {
            String message;
            String[] messages = null;
            String response;

            User _user = new User();
            ArrayList<Object> collection = new ArrayList<Object>();
            switch (command) {
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

//            Ya RegisterCustomer
                case "REGISTER":
                    message = value;

                    messages = message.split(";-;");

                    String status = _user.RegisterCustomer(messages[0], messages[1], messages[2], messages[3]);
                    SendMessage(status + ";-;" + messages[0]);
                    break;

//            Logic fitur reservation
                case "DATARESTAURANT":
//                Inisiasi class restaurant untuk dapat array data restaurant
                    Restaurant rest = new Restaurant();
                    collection = rest.getData();
//                String untuk response
                    response = "";
//                Looping untuk kirim data sebagai string
                    for (Object object : collection) {
//                    Type casting object ke restaurant
                        Restaurant restaurant = (Restaurant) object;
//                    Inisiasi data yang dikirim
                        int id = restaurant.getId();
                        String name = restaurant.getName();
                        int peoplePerTable = restaurant.getPeoplePerTable();
//                    Tambahkan data
                        response = response
                                + String.valueOf(id) + "&"
                                + name + "&"
                                + String.valueOf(peoplePerTable) + ";";
                    }
//                Kirim seluruh data ke client
                    SendMessage(response);
                    break;

                case "RESERVATION":
                    messages = value.split(";");
//                    String untuk response
                    response = "";
//                    Inisiasi tiap data yang didapat untuk dimasukkan ke constructor
                    Date startHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(messages[0]);
                    Date endHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(messages[1]);
                    int tablesCount = Integer.valueOf(messages[2]);
                    int user_id = Integer.valueOf(messages[3]);
                    int restaurant_id = Integer.valueOf(messages[4]);

//                    Inisiasi restaurant yang dipilih
                    Restaurant res = new Restaurant();
                    Restaurant selected_restaurant = res.getSelectedRestaurant(restaurant_id);

//                    Inisiasi booking
                    Bookings booking = new Bookings(startHour, endHour, tablesCount, user_id, restaurant_id);

//                    VALIDASI BOOKING
//                    Ambil time (jam, menit, second) saja pada startHour dan EndHour
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String strStartTime = messages[0].split(" ")[1];
                    String strEndTime = messages[1].split(" ")[1];

                    Date startTime = sdf.parse(strStartTime);
                    Date endTime = sdf.parse(strEndTime);

//                    Apabila restaurant belum buka atau sudah tutup
                    if (startTime.before(selected_restaurant.getOpenHour()) || endTime.after(selected_restaurant.getCloseHour())) {
                        response = "False;False;Reservasi gagal dilakukan. Restaurant tidak buka pada waktu yang diinginkan.";
                        SendMessage(response);
                        break;
                    }

//                    Apabila jadwal tidak tersedia karena sudah di booking orang lain
                    boolean tableCountIsAvailable = booking.checkTableAvailability();
                    if (!tableCountIsAvailable) {
                        response = "False;False;Reservasi gagal dilakukan. Banyak meja yang diinginkan tidak tersedia.";
                        SendMessage(response);
                        break;
                    }

//                    Panggil method insert untuk memasukkan data booking baru ke database
                    booking.insert();
//                    Check apakah restaurant menyediakan pre order?
                    boolean preOrderIsAvailable = booking.checkPreOrder();
//                    Jika tidak, kirimkan True satu kali dan false satu kali yang menandakan reservasi berhasil dan pre order tidak dapat dilakukan
                    if (!preOrderIsAvailable) {
                        response = "True;False;Reservasi berhasil dilakukan.";
                        SendMessage(response);
                        break;
                    }
//                    Jika ya, kirimkan True dua kali yang menandakan reservasi berhasil dan pre order dapat dilakukan
                    response = "True;True;Reservasi berhasil dilakukan. Restaurant ini menyediakan jasa Pre Order, apakah anda ingin melakukan Pre Order?";
                    SendMessage(response);
                    break;
                case "GETBOOKINGINDEX":
                    Bookings b = new Bookings();
//                    Ambil booking terakhir
                    int last_id = b.getLastIndex();
//                    Kirim id dari booking yang sekarang untuk melakukan pre order
                    SendMessage(String.valueOf(last_id));
                    break;
//                Logic PreOrder
                case "DATAMENU":
//                Inisiasi class menu untuk dapat array data untuk
                    Menu menu = new Menu();
                    collection = menu.getData(Integer.parseInt(value));
//                String untuk response
                    response = "";
//                Looping untuk kirim data sebagai string
                    for (Object object : collection) {
//                    Type casting object ke menu
                        Menu _menu = (Menu) object;
//                    Inisiasi data yang dikirim
                        int id = _menu.getId();
                        String name = _menu.getName();
                        double price = _menu.getPrice();
//                    Tambahkan data
                        response = response
                                + String.valueOf(id) + "&"
                                + name + "&"
                                + String.valueOf(price) + ";";
                    }
//                Kirim seluruh data ke client
                    SendMessage(response);
                    break;
                case "PREORDER":
                    messages = value.split(";");
//                    String untuk response
                    response = "";
//                    Inisiasi tiap data yang didapat untuk dimasukkan ke constructor
                    int booking_id = Integer.valueOf(messages[0]);
                    int menu_id = Integer.valueOf(messages[1]);
                    int amount = Integer.valueOf(messages[2]);
                    double subtotal = Double.valueOf(messages[3]);

                    Preorder po = new Preorder(booking_id, menu_id, amount, subtotal);
                    po.insert();

                    SendMessage("True;Preorder berhasil dilakukan. Apakah anda ingin melakukan Preorder lagi?");
                    break;
                //  Logic Display Bookings
                case "DISPLAYBOOKINGS":
//                Inisiasi class booking untuk dapat array data untuk
                    Bookings book = new Bookings();
                    message = value;
                    collection = book.display("6");
//                String untuk response
                    response = "";
//                Looping untuk kirim data sebagai string
                    for (Object object : collection) {
//                    Type casting object ke bookings
                        Bookings books = (Bookings) object;
//                    Inisiasi data yang dikirim
                        String nama = books.getCustomerName();
                        Date start = books.getStartHour();
                        Date end = books.getEndHour();
                        int table = books.getTablesCount();
//                    Tambahkan data
                        response = response
                                + nama + "&"
                                + String.valueOf(start) + "&"
                                + String.valueOf(end) + "&"
                                + String.valueOf(table) + ";";
                    }
                    System.out.println("testing");
//                Kirim seluruh data ke client
                    SendMessage(response);
                    break;
//            Logic lain dibawah sini
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
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
