package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class MyConnection {
    // <editor-fold defaultstate="collapsed" desc="Fields">
    Connection connect;
    Statement stat;
    ResultSet result;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/ezbooking", "root", "");
        } catch (Exception e) {
            System.out.println("Error Get Connection : " + e);
        }
        return connect;
    }
    // </editor-fold>
}
