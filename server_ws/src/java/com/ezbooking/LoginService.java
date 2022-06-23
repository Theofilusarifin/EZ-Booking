/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ezbooking;

import com.ezbooking.model.User;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "LoginService")
public class LoginService {

    User user;
    ArrayList<String> userList;

    public LoginService() {
        user = new User();
        userList = user.select();
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return "true-admin";
        } else if (username.equals("user") && password.equals("user")) {
            return "true-user";
        }
        return "false";
    }
}
