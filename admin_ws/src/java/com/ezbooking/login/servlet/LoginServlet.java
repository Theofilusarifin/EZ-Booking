/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ezbooking.login.servlet;

import com.ezbooking.login.bean.LoginBean;
import com.ezbooking.login.database.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henri
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    private LoginDao loginDao;
    
    public void init() {
        loginDao = new LoginDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (loginDao.checkLogin1(loginBean).equals("true")) {
//            request.setAttribute("alertMsg", "Login Successfull");
//
//            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//            rd.include(request, response);

                response.sendRedirect("index.jsp");
            } else if (loginDao.checkLogin1(loginBean).equals("false")) {
//            request.setAttribute("alertMsg", "Username or Password is incorrect");
//
//            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//            rd.include(request, response);

                response.sendRedirect("login.jsp");
            } else {

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if (loginDao.checkLogin(loginBean).equals("true")) {
//            response.sendRedirect("index.jsp");
//        } else if (loginDao.checkLogin(loginBean).equals("false")) {
//            response.sendRedirect("login.jsp");
//        }
    }
}
