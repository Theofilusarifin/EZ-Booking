<%-- 
    Document   : loginprocess
    Created on : Jun 24, 2022, 1:30:41 PM
    Author     : henri
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <jsp:useBean id="user" scope="session" class="com.ezbooking.login.bean.LoginBean" />
        <jsp:setProperty name="user" property="username"/>
        <jsp:setProperty name="user" property="password"/>
        <%
            try {
                String username = user.getUsername();
                String password = user.getPassword();

                com.ezbooking.method.LoginService_Service service = new com.ezbooking.method.LoginService_Service();
                com.ezbooking.method.LoginService port = service.getLoginServicePort();
                java.lang.String data = port.checkLogin(username, password);

                if (data.equals("true")) {
                    response.sendRedirect("showData.jsp");
                } else if (data.equals("false")) {
                    request.setAttribute("alertMsg", "Username or Password is incorrect");

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
                    
                    response.sendRedirect("index.jsp");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        %>
    </body>
</html>
