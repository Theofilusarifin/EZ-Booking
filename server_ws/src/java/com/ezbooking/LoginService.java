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
/**
 *
 * @author Meliyana
 */
@WebService(serviceName = "LoginService")
public class LoginService {

    User user;
    ArrayList<String> listOfUser;

    public LoginService() {
        user = new User();
    }

   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        String result = "";
        return result;
    }
}
