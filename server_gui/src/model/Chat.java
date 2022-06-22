
package model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Chat extends MyConnection{
    
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
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into chats(message, date, from, to) values (?,?,?,?)");

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
    // </editor-fold>
}
