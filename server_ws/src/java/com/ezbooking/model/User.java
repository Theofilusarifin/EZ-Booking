/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ezbooking.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Meliyana
 */
public class User extends MyConnection{
    //<editor-fold defaultstate="collapsed" desc="Fields">
    protected Statement statement;
    protected ResultSet result;

    private String name;
    private String username;
    private String password;
    private String role;
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
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

    public boolean CheckLogin(String username, String password) {
        try {
            this.statement = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement("select * from users"
                    + " where username = ? and password = ? and role != ?;");
            sql.setString(1, username);
            sql.setString(2, password);
            sql.setString(3, "admin");
            result = sql.executeQuery();
            if (this.result.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error User CheckLogin, Error: " + e.getMessage());
        }
        return false;
    }

    public String CheckRole(String username, String password) {
        String role = "";
        try {
            this.statement = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement("select * from users"
                    + " where username = ? and password = ?;");
            sql.setString(1, username);
            sql.setString(2, password);
            result = sql.executeQuery();
            if (this.result.next()) {
                role = result.getString("role") + ";-;" + result.getString("name") + ";-;" + result.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Error User CheckLogin, Error: " + e.getMessage());
        }
        return role;
    }

    public boolean CheckSameUsername(String username) {
        try {
            this.statement = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement("select * from users"
                    + " where username = ?;");
            sql.setString(1, username);
            result = sql.executeQuery();
            if (this.result.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error User CheckSameUsername, Error: " + e.getMessage());
        }
        return false;
    }

// </editor-fold>
}
