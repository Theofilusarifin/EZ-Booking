/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ezbooking.login.database;

import com.ezbooking.login.bean.LoginBean;

public class loginDao {

    com.ezbooking.LoginService_Service service;
    com.ezbooking.LoginService port;

    public String checkLogin(LoginBean loginBean) {
        service = new com.ezbooking.LoginService_Service();
        port = service.getLoginServicePort();
        return port.checkLogin(loginBean.getUsername(), loginBean.getPassword());
    }
//    public String testLogin(LoginBean loginBean) {
//        if ("admin".equals(loginBean.getUsername()) && "password".equals(loginBean.getPassword())) {
//            return "true";
//        }
//        return "false";
//    }
}
