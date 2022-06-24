<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Login
    Created on : Jun 19, 2022, 10:41:50 PM
    Author     : Meliyana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Page</title>
        <script src="/js/jquery-3.6.0.min.js"></script>
    </head>
    <%
//        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {
//            String uname = request.getParameter("username");
//            String pass = request.getParameter("password");
//            String ret;
//
//            com.ezbooking.LoginService_Service service;
//            com.ezbooking.LoginService port;
//            service = new com.ezbooking.LoginService_Service();
//            port = service.getLoginServicePort();
//            
//            ret = port.checkLogin(uname, pass);
//            
//            if (ret.equals("true")) {
//                out.println("Login Successful");
//            } else if (ret.equals("false")) {
//                out.println("Username or Password is wrong");
//            }
//            if (uname.equals("") && pass.equals("")) {
//
//            } else {
//                if (uname.equals("admin") && pass.equals("password")) {
//                    response.sendRedirect("index.jsp");
//                } else {
//                    out.println("Username or Password is wrong");
//                }
//            }
//        }
%>
    <body>
        <form action="<%=request.getContextPath()%>/LoginServlet" method="post">  
            Username:<input type="text" name="username"><br>  
            Password:<input type="password" name="password"><br>
            <button id="btnSubmit" type="submit">Submit</button>
        </form>
    </body>
    <%String message = (String) request.getAttribute("alertMsg");%>
    <script type="text/javascript">
        $("#btnSubmit").click(function () {
            var msg = "<%=message%>";
            alert(msg);
        })
    </script>
</html>
