package model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Bookings extends MyConnection{

    private int id;
    private Timestamp startHour;
    private Timestamp endHour;
    private int tablesCount;    
    private int user_id;
    private int restaurant_id;    
    private String customerName;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Timestamp getStartHour() {
        return startHour;
    }

    public void setStartHour(Timestamp startHour) {
        this.startHour = startHour;
    }

    public Timestamp getEndHour() {
        return endHour;
    }

    public void setEndHour(Timestamp endHour) {
        this.endHour = endHour;
    }

    public int getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(int tablesCount) {
        this.tablesCount = tablesCount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public Bookings (String _user, Timestamp _start, Timestamp _end, int _tables) {
        this.customerName = _user;
        this.startHour = _start;
        this.endHour = _end;
        this.tablesCount = _tables;
        
    }

    public ArrayList<Object> display() { //menampilkan data bookings untuk restaurant
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement)connect.createStatement();
            this.result = this.stat.executeQuery("SELECT u.name, b.startHour, b.endHour, b.tablesCount " +
                "FROM bookings b inner join users u on b.user_id = u.id" +
                "WHERE restaurant_id='" + this.restaurant_id + "';");
            
            while(this.result.next()) {
                Bookings book = new Bookings(
                        this.result.getString("name"),
                        this.result.getTimestamp("startHour"),
                        this.result.getTimestamp("endHour"),
                        this.result.getInt("tablesCount")
                        
                );
                collections.add(book);
            }
        } catch (Exception ex) {
            System.out.println("Error di display : " + ex); 
        }
        return collections;
    }
}
