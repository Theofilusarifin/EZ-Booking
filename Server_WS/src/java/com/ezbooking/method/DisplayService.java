/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ezbooking.method;

import com.ezbooking.model.Restaurant;
import com.ezbooking.model.Booking;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "DisplayService")
public class DisplayService {
    Restaurant resto;
    ArrayList<String> restoList;
    Booking book;
    ArrayList<String> bookList;
    
    @WebMethod(operationName = "display")
    public String display() {
        resto = new Restaurant();
        restoList = resto.displayResto();
        String collection = "";
        String counter = "";
        for (int i = 0; i < restoList.size(); i++) {
            if (i+1 != restoList.size()) {
                counter = "/&/";
            }
            else {
                counter = "";
            }
            collection += restoList.get(i)+counter;
        }
        return collection;
    }
    
    @WebMethod(operationName = "displayBook")
    public String displayBook(String kode) {
        book = new Booking();
        bookList = book.displayBook(kode);
        String collection = "";
        String counter = "";
        for (int i = 0; i < bookList.size(); i++) {
            if (i+1 != bookList.size()) {
                counter = "/&/";
            }
            else {
                counter = "";
            }
            collection += bookList.get(i)+counter;
        }
        return collection;
    }
}
