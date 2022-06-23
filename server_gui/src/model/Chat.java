package model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Chat extends MyConnection {

    // <editor-fold defaultstate="collapsed" desc="Fields">
    private int id;
    private String message;
    private Date date;
    private int from;
    private int to;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Chat() {
        getConnection();
    }

    public Chat(int id, String message, Date date, int from, int to) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.from = from;
        this.to = to;
        getConnection();
    }

    public Chat(String message, Date date, int from, int to) {
        this.message = message;
        this.date = date;
        this.from = from;
        this.to = to;
        getConnection();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public void insert() {
        try {
            if (!connect.isClosed()) {
                stat = (Statement) connect.createStatement();
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into chats values (null,?,?,?,?)");

                sql.setString(1, this.getMessage());

//                Konversi datetime ke string dengan format yang benar
                SimpleDateFormat strFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startDate = strFormatter.format(this.getDate());
                sql.setString(2, startDate);

                sql.setInt(3, this.getFrom());
                sql.setInt(4, this.getTo());

                sql.executeUpdate();
                sql.close();
            } else {
                System.out.println("Koneksi Hilang");
            }
        } catch (Exception e) {
            System.out.println("Error di chat insert, Error: " + e);
        }
    }

    public ArrayList<Object> getChat(int id1, int id2) {
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement) connect.createStatement();
            this.result = this.stat.executeQuery("SELECT * FROM chats c where (c.from="
                    + id1 + " and c.to=" + id2 + ") or (c.from=" + id2 + " and c.to=" + id1 + ");");

            while (this.result.next()) {
                Chat chat = new Chat(
                        this.result.getInt("id"),
                        this.result.getString("message"),
                        this.result.getTimestamp("date"),
                        this.result.getInt("from"),
                        this.result.getInt("to"));
                collections.add(chat);
            }

        } catch (Exception ex) {
            System.out.println("Error di method getChat : " + ex);
        }
        return collections;
    }
    // </editor-fold>
}
