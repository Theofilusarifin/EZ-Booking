package model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Restaurant extends MyConnection {

    // <editor-fold defaultstate="collapsed" desc="Fields">
    protected Statement statement;
    protected ResultSet result;

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

    public Restaurant(int id, String name, String address, String phoneNumber, Date openHour, Date closeHour, int tablesCount, int peoplePerTable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.tablesCount = tablesCount;
        this.peoplePerTable = peoplePerTable;
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
    public void insertRestaurant(String restaurantName, String address, String phoneNumber, Time openHour, Time closeHour, int tablesCount, int peoplePerTable, int user_id) {
        try {
            if (!connect.isClosed()) {
                stat = (Statement) connect.createStatement();
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("insert into restaurants(name, address, phoneNumber, openHour, closeHour, tablesCount, peoplePerTable, user_id) values (?,?,?,?,?,?,?,?)");
                sql.setString(1, restaurantName);
                sql.setString(2, address);
                sql.setString(3, phoneNumber);
                sql.setTime(4, openHour);
                sql.setTime(5, closeHour);
                sql.setInt(6, tablesCount);
                sql.setInt(7, peoplePerTable);
                sql.setInt(8, user_id);

                sql.executeUpdate();
                sql.close();
            } else {
                System.out.println("Koneksi Hilang");
            }
        } catch (Exception e) {
            System.out.println("Error User insert, Error: " + e);
        }
    }

    public String RegisterRestaurant(String restaurantName, String address, String phoneNumber, int user_id) {
        String status = "";
        try {
            if (!connect.isClosed()) {
                this.statement = (Statement) connect.createStatement();
                PreparedStatement sqlCheck = (PreparedStatement) connect.prepareStatement("select * from restaurants"
                        + " where name = ?;");
                sqlCheck.setString(1, restaurantName);
                result = sqlCheck.executeQuery();

                int count = 0;
                while (this.result.next()) {
                    count++;
                    //System.out.println("count: " + count);
                }

                if (count == 0) {
                    PreparedStatement sqlInsert = (PreparedStatement) connect.prepareStatement("insert into restaurants(name, address, phoneNumber, user_id) values (?,?,?,?)");
                    sqlInsert.setString(1, restaurantName);
                    sqlInsert.setString(2, address);
                    sqlInsert.setString(3, phoneNumber);
                    sqlInsert.setInt(4, user_id);

                    sqlInsert.executeUpdate();
                    sqlInsert.close();
                    status = "RegSuccess";
                } else {
                    status = "RegFailed";
                }
            }
        } catch (Exception e) {
            System.out.println("Error User Register, Error: " + e.getMessage());
        }
        return status;
    }

    public int selectIdResto(String username, String password) {
        int data = 0;
        try {
            this.statement = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement("select * from users as u inner join restaurants as r on u.id = r.user_id where role = ? and username = ? and password = ?;");
            sql.setString(1, "restaurant");
            sql.setString(2, username);
            sql.setString(3, password);

            result = sql.executeQuery();
            if (this.result.next()) {
                data = result.getInt("r.id");
            }
        } catch (Exception e) {
            System.out.println("Error Restaurant selectIdResto, Error: " + e.getMessage());
        }
        return data;
    }

    public String selectResto(int idResto) {
        String data = "";
        try {
            this.statement = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement("select * from restaurants where id = ?");
            sql.setInt(1, idResto);

            result = sql.executeQuery();
            if (this.result.next()) {
                data = result.getInt("id") + ";-;"
                        + result.getString("name") + ";-;"
                        + result.getString("address") + ";-;"
                        + result.getString("phoneNumber") + ";-;"
                        + result.getTime("openHour") + ";-;"
                        + result.getTime("closeHour") + ";-;"
                        + result.getInt("tablesCount") + ";-;"
                        + result.getInt("peoplePerTable") + ";-;"
                        + result.getInt("user_id");
            }
        } catch (Exception e) {
            System.out.println("Error Restaurant selectResto, Error: " + e.getMessage());
        }
        return data;
    }

    public Restaurant getSelectedRestaurant(int restaurant_id) { //Ambil data restaurant untuk combobox di form reservation
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement) connect.createStatement();
            this.result = this.stat.executeQuery("SELECT * FROM restaurants where id = " + restaurant_id + ";");

            while (this.result.next()) {
                Restaurant restaurant = new Restaurant(
                        this.result.getInt("id"),
                        this.result.getString("name"),
                        this.result.getString("address"),
                        this.result.getString("phoneNumber"),
                        new SimpleDateFormat("HH:mm:ss").parse(this.result.getString("openHour")),
                        new SimpleDateFormat("HH:mm:ss").parse(this.result.getString("closeHour")),
                        this.result.getInt("tablesCount"),
                        this.result.getInt("peoplePerTable")
                );
                collections.add(restaurant);
            }
        } catch (Exception ex) {
            System.out.println("Error di method getSelectedRestaurant : " + ex);
        }
        Restaurant restaurant = (Restaurant) collections.get(0);
        return restaurant;
    }

    public ArrayList<Object> getData() { //Ambil data restaurant untuk combobox di form reservation
        ArrayList<Object> collections = new ArrayList<Object>();
        try {
            this.stat = (Statement) connect.createStatement();
            this.result = this.stat.executeQuery("SELECT * FROM restaurants;");

            while (this.result.next()) {
                Restaurant restaurant = new Restaurant(
                        this.result.getInt("id"),
                        this.result.getString("name"),
                        this.result.getInt("peoplePerTable")
                );
                restaurant.setUser_id(this.result.getInt("user_id"));
                collections.add(restaurant);
            }
        } catch (Exception ex) {
            System.out.println("Error di method getDataRestaurant : " + ex);
        }
        return collections;
    }
    // </editor-fold>
}
