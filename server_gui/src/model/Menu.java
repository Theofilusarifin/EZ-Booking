/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jabeshnehemiah
 */
public class Menu extends MyConnection {

    private int id;
    private String name;
    private double price;
    private int restaurant_id;

    public Menu(int id, String name, double price, int restaurant_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant_id = restaurant_id;
        getConnection();
    }

    public Menu(String name, double price, int restaurant_id) {
        this.name = name;
        this.price = price;
        this.restaurant_id = restaurant_id;
        getConnection();
    }

    public Menu() {
        getConnection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public void insert() {
        try {
            stat = (Statement) connect.createStatement();
            if (!connect.isClosed()) {
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into menus(name,price,restaurant_id) values(?,?,?)");
                sql.setString(1, name);
                sql.setDouble(2, price);
                sql.setInt(3, restaurant_id);
                sql.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
