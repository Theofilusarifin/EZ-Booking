/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ezbooking.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezbooking.login.bean.LoginBean;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDao {

    com.ezbooking.LoginService_Service service;
    com.ezbooking.LoginService port;

    Statement stat;
    ResultSet result;

    //buat pake WebService
    public String checkLogin(LoginBean loginBean) {
        service = new com.ezbooking.LoginService_Service();
        port = service.getLoginServicePort();
        return port.checkLogin(loginBean.getUsername(), loginBean.getPassword());
    }
    //buat test
//    public String testLogin(LoginBean loginBean) {
//        if ("admin".equals(loginBean.getUsername()) && "password".equals(loginBean.getPassword())) {
//            return "true";
//        }
//        return "false";
//    }
//    public String checkLogin1(LoginBean loginBean) throws ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        try {
//            Connection connection = (Connection) DriverManager.getConnection(
//                    "jdbc:mysql://localhost/ezbooking", "root", "");
//            stat = (Statement) connection.createStatement();
//            result = stat.executeQuery("select * from users where role = 'admin'");
//            while (result.next() == true) {
//                if (result.getString("username").equals(loginBean.getUsername())
//                        && result.getString("password").equals(loginBean.getPassword())) {
//                    return "true";
//                }
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return "false";
//    }
//
//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}
