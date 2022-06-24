/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ezbooking.model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking extends MyConnection{
    
    private int id;
    private Date startHour;
    private Date endHour;
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

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
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
    
    public Booking() {
        getConnection();
    }
    
    public Booking(Date startHour, Date endHour, int tablesCount, int user_id, int restaurant_id) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.tablesCount = tablesCount;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        getConnection();
    }

    public Booking(String _user, Date _start, Date _end, int _tables) {
        this.customerName = _user;
        this.startHour = _start;
        this.endHour = _end;
        this.tablesCount = _tables;
        getConnection();
    }
    
    public ArrayList<String> displayBook(String kode) { //menampilkan data bookings untuk restaurant
        ArrayList<String> collections = new ArrayList<String>();
        SimpleDateFormat strFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.stat = (Statement) connect.createStatement();
            this.result = this.stat.executeQuery("SELECT u.name, b.startHour, b.endHour, b.tablesCount "
                    + "FROM bookings b inner join users u on b.user_id = u.id "
                    + "WHERE b.restaurant_id=" + kode + ";");

            while (this.result.next()) {
                Booking book = new Booking(
                        this.result.getString("name"),
                        this.result.getTimestamp("startHour"),
                        this.result.getTimestamp("endHour"),
                        this.result.getInt("tablesCount")
                );
                collections.add(book.getCustomerName() + ";-;" + strFormatter.format(book.getStartHour()) + ";-;"
                        + strFormatter.format(book.getEndHour())+ ";-;" + book.getTablesCount());
            }
        } catch (Exception ex) {
            System.out.println("Error di display : " + ex);
        }
        return collections;
    }
}
