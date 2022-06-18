package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends MyConnection {
    
    // <editor-fold defaultstate="collapsed" desc="Fields">
    private int id;
    private String name;
    private double price;
    private int restaurant_id;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Properties">
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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
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
    // </editor-fold>

}