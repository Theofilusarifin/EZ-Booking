package model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Preorder extends MyConnection{
    
    // <editor-fold defaultstate="collapsed" desc="Fields">
    private int booking_id;
    private int menu_id;
    private int amount;
    private double subtotal;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Preorder() {
        getConnection();
    }
        
    public Preorder(int booking_id, int menu_id, int amount, double subtotal) {
        this.booking_id = booking_id;
        this.menu_id = menu_id;
        this.amount = amount;
        this.subtotal = subtotal;
        getConnection();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public void insert() {
        try {
            if (!connect.isClosed()) {
                stat = (Statement) connect.createStatement();
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into preorders(booking_id, menu_id, amount, subtotal) values (?,?,?,?)");

                sql.setInt(1, this.getBooking_id());
                sql.setInt(2, this.getMenu_id());
                sql.setInt(3, this.getAmount());
                sql.setDouble(4, this.getSubtotal());
                sql.executeUpdate();
                sql.close();
            } else {
                System.out.println("Koneksi Hilang");
            }
        } catch (Exception e) {
            System.out.println("Error di preorder insert, Error: " + e);
        }
    }
    // </editor-fold>
}
