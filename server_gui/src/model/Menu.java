package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            } else {
                System.out.println("Koneksi hilang");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Object> getData(int restaurant_id) { //Ambil data menu untuk combobox di form pre order
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement) connect.createStatement();
            this.result = this.stat.executeQuery("SELECT * FROM menus where restaurant_id = " + restaurant_id + ";");

            while (this.result.next()) {
                Menu menu = new Menu(
                        this.result.getInt("id"),
                        this.result.getString("name"),
                        this.result.getInt("price"),
                        this.result.getInt("restaurant_id")
                );
                collections.add(menu);
            }
        } catch (Exception ex) {
            System.out.println("Error di method getDataMenu : " + ex);
        }
        return collections;
    }
    // </editor-fold>

}
