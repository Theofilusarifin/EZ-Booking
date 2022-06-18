package model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bookings extends MyConnection{

    // <editor-fold defaultstate="collapsed" desc="Fields">
    private int id;
    private Date startHour;
    private Date endHour;
    private int tablesCount;    
    private int user_id;
    private int restaurant_id;    
    private String customerName;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Properties">
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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Bookings(Date startHour, Date endHour, int tablesCount, int user_id, int restaurant_id) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.tablesCount = tablesCount;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        getConnection();
    }
    
    public Bookings (String _user, Date _start, Date _end, int _tables) {
        this.customerName = _user;
        this.startHour = _start;
        this.endHour = _end;
        this.tablesCount = _tables;
        getConnection();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public void insert() {
        try {
            if (!connect.isClosed()) {
                stat = (Statement) connect.createStatement();
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into bookings(startHour, endHour, tablesCount, user_id, restaurant_id) values (?,?,?,?,?)");
                
//                Konversi datetime ke string dengan format yang benar
                SimpleDateFormat strFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startDate = strFormatter.format(this.getStartHour());
                sql.setString(1, startDate);
                
                String endDate = strFormatter.format(this.getEndHour());
                sql.setString(2, endDate);
                
                sql.setInt(3, this.getTablesCount());
                sql.setInt(4, this.getUser_id());
                sql.setInt(5, this.getRestaurant_id());

                System.out.println(sql);
                sql.executeUpdate();
                sql.close();
            } else {
                System.out.println("Koneksi Hilang");
            }
        } catch (Exception e) {
            System.out.println("Error di booking insert, Error: " + e);
        }
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
                        this.result.getDate("startHour"),
                        this.result.getDate("endHour"),
                        this.result.getInt("tablesCount")
                        
                );
                collections.add(book);
            }
        } catch (Exception ex) {
            System.out.println("Error di display : " + ex); 
        }
        return collections;
    }
    // </editor-fold>

}
