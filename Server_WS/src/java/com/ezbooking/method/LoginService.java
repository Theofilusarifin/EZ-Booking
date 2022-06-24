/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ezbooking.method;

import com.ezbooking.model.User;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "LoginService")
public class LoginService {


    private User user;
    private ArrayList<String> userList;

    public LoginService() {
        user = new User();
        userList = user.select();
    }

    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        for (int i = 0; i < userList.size(); i++) {//miftah;-;pwd;ahmad-pwd
            String[] eachUser = userList.get(i).split(";-;");//i=0 -> miftah;-;pwd || i=1 -> ahmad;-;pwd
            String uname = eachUser[0];
            String pass = eachUser[1];
            if (username.equals(uname) && password.equals(pass)) {
                return "true";
            }
        }
        return "false";
    }
}
