/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author REYNARD
 */
public class Restaurant extends MyConnection {
    
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private Date openHour;
    private Date closeHour;
    private int tablesCount;
    private int peoplePerTable;
    private String owner;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Date openHour) {
        this.openHour = openHour;
    }

    public Date getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Date closeHour) {
        this.closeHour = closeHour;
    }

    public int getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(int tablesCount) {
        this.tablesCount = tablesCount;
    }

    public int getPeoplePerTable() {
        return peoplePerTable;
    }

    public void setPeoplePerTable(int peoplePerTable) {
        this.peoplePerTable = peoplePerTable;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public Restaurant() {
        getConnection();
    }

    public Restaurant(int _id, String _name, String _address, String _phone, Date _open, 
            Date _close, int _count, int _people, String _owner) {
        this.id = _id;
        this.name = _name;
        this.address = _address;
        this.phoneNumber = _phone;
        this.openHour = _open;
        this.closeHour = _close;
        this.tablesCount = _count;
        this.peoplePerTable = _people;
        this.owner = _owner;
        getConnection();
    }
    
    public ArrayList<String> displayResto() {
        ArrayList<String> resto = new ArrayList<>();
        try {
            stat = (Statement) connect.createStatement();
            result = stat.executeQuery("SELECT r.*, u.name FROM restaurants r "
                    + "inner join users u on r.user_id = u.id;");
            while (result.next()) {
                Restaurant r = new Restaurant(result.getInt("r.id"), result.getString("r.name"), 
                        result.getString("r.address"), result.getString("r.phoneNumber"),
                        result.getTime("r.openHour"), result.getTime("r.closeHour"),result.getInt("r.tablesCount"),
                        result.getInt("r.peoplePerTable"), result.getString("u.name"));
                resto.add(r.getId() + ";-;" + r.getName() + ";-;" + r.getAddress()+ ";-;" + r.getPhoneNumber()
                + ";-;" + r.getOpenHour()+ ";-;" + r.getCloseHour()+ ";-;" + r.getTablesCount()
                + ";-;" + r.getPeoplePerTable()+ ";-;" + r.getOwner());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resto;
    }
}
