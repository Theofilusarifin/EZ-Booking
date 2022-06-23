/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ezbooking.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meliyana
 */
public class User extends MyConnection {

    //<editor-fold defaultstate="collapsed" desc="Fields">
    protected Statement statement;
    protected ResultSet result;

    private int id;
    private String name;
    private String username;
    private String password;
    private String role;
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public User() {
        getConnection();
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        getConnection();
    }

    public User(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        getConnection();
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public void insert(String username, String password) {
        try {
            if (!connect.isClosed()) {
                stat = (Statement) connect.createStatement();
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into users(username, password) values (?,?)");
                sql.setString(1, username);
                sql.setString(2, password);
                sql.executeUpdate();
                sql.close();
            } else {
                System.out.println("Koneksi Hilang");
            }
        } catch (Exception e) {
            System.out.println("Error User insert, Error: " + e);
        }
    }

    public ArrayList<String> select() {
        ArrayList<String> data = new ArrayList<>();
        try {
            stat = (Statement) connect.createStatement();
            result = stat.executeQuery("select * from users");
            while (result.next()) {
                User us = new User(result.getString("username"), result.getString("password"), result.getString("role"), result.getString("name"));
                data.add(us.getUsername() + ";-;" + us.getPassword() + ";-;" + us.getRole() + ";-;" + us.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

// </editor-fold>
}
