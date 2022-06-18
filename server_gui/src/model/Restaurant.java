package model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Restaurant extends MyConnection{
    
    // <editor-fold defaultstate="collapsed" desc="Fields">
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private Date openHour;
    private Date closeHour;
    private int tablesCount;    
    private int peoplePerTable;
    private int user_id;    
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

    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Restaurant() {
        getConnection();
    }
    
    public Restaurant(int id, String name, int peoplePerTable) {
        this.id = id;
        this.name = name;
        this.peoplePerTable = peoplePerTable;
        getConnection();
    }
    
    public Restaurant(int id, String name, String address, String phoneNumber, Date openHour, Date closeHour, int tablesCount, int peoplePerTable, int user_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.tablesCount = tablesCount;
        this.peoplePerTable = peoplePerTable;
        this.user_id = user_id;
        getConnection();
    }

    public Restaurant(String name, String address, String phoneNumber, Date openHour, Date closeHour, int tablesCount, int peoplePerTable, int user_id) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.tablesCount = tablesCount;
        this.peoplePerTable = peoplePerTable;
        this.user_id = user_id;
        getConnection();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
    public ArrayList<Object> getDataRestaurant() { //Ambil data restaurant untuk combobox di form reservation
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement)connect.createStatement();
            this.result = this.stat.executeQuery("SELECT * FROM restaurants;");
            
            while(this.result.next()) {
                Restaurant restaurant = new Restaurant(
                        this.result.getInt("id"),
                        this.result.getString("name"),
                        this.result.getInt("peoplePerTable")      
                );
                collections.add(restaurant);
            }
        } catch (Exception ex) {
            System.out.println("Error di method getDataRestaurant : " + ex); 
        }
        return collections;
    }
    // </editor-fold>
}
