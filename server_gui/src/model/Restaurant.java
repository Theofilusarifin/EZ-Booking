package model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Restaurant extends MyConnection{
    
    // <editor-fold defaultstate="collapsed" desc="Fields">
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private Timestamp openHour;
    private Timestamp closeHour;
    private int tablesCount;    
    private int peoplePerTable;
    private int user_id;    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Restaurant(int id, String name, String address, String phoneNumber, Timestamp openHour, Timestamp closeHour, int tablesCount, int peoplePerTable, int user_id) {
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

    public Restaurant(String name, String address, String phoneNumber, Timestamp openHour, Timestamp closeHour, int tablesCount, int peoplePerTable, int user_id) {
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

    public Timestamp getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Timestamp openHour) {
        this.openHour = openHour;
    }

    public Timestamp getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Timestamp closeHour) {
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

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public ArrayList<Object> getDataRestaurant() { //Ambil data restaurant untuk combobox di form reservation
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement)connect.createStatement();
            this.result = this.stat.executeQuery("SELECT * form restaurants;");
            
            while(this.result.next()) {
                Restaurant restaurant = new Restaurant(
                        this.result.getString("name"),
                        this.result.getString("address"),
                        this.result.getString("phoneNumber"),
                        this.result.getTimestamp("openHour"),
                        this.result.getTimestamp("closeHour"),
                        this.result.getInt("tablesCount"),
                        this.result.getInt("peoplePerTable"),
                        this.result.getInt("user_id")
                        
                );
                collections.add(restaurant);
            }
        } catch (Exception ex) {
            System.out.println("Error di display : " + ex); 
        }
        return collections;
    }
    // </editor-fold>
}
