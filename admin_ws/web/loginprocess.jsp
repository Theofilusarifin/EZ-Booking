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

                com.ezbooking.LoginService_Service service = new com.ezbooking.LoginService_Service();
                com.ezbooking.LoginService port = service.getLoginServicePort();
                java.lang.String data = port.checkLogin(username, password);

                out.println(data);
                out.println(username);
                out.println(password);

                if (data.equals("true")) {
                    response.sendRedirect("showData.jsp");
                } else if (data.equals("false")) {
                    response.sendRedirect("login.jsp");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        %>

    </body>
</html>
