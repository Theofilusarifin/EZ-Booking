<%-- 
    Document   : index
    Created on : Jun 19, 2022, 10:45:27 PM
    Author     : Meliyana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Page</title>
        <script src="/js/jquery-3.6.0.min.js"></script>
        <style type="text/css">

            .logo{
                font-family: 'Vanessia Demo';
                font-weight: bold;
                font-size:80px;
                margin-top:50px;
                letter-spacing: 2px;
                color:#021A4A;
                text-align:center;
            }

            div{
                margin:12px;
            }

            .container{
                margin-top:20px;
                display:flex;
                justify-content: center;
                align-items: center;

            }
            body{
                background-color:#FFFFFF;
            }
            .card{
                background-color:#021A4A;
                width:400px;
                height:280px;
                border-radius: 16px;
                text-align:center;
                box-shadow: 0 16px 31px -17px rgba(0, 50, 97, 0.8);
            }

            h1{
                color:white;
                right:300px;
            }
            .font-inner{
                color:white;

            }

            p,h1,h2,h3,h4,h5,h6,label,.mybutton {
                font-family: 'Poppins', sans-serif;
                font-weight: normal;
                margin:12px;
            }

            .group{
                justify-content: center;
                align-items: center;
            }
        </style>
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
        <form action="<%=request.getContextPath()%>/loginprocess.jsp" method="post">  
            <div class="logo"> ezbooking </div>
            <div class="container">
                <div class="card">
                    <div class="group">
                        <h1>LOGIN</h1>
                        <form>
                            <div> <label class="font-inner"> Username </label></div>
                            <div> <input type="text" name="username"></div>
                            <div> <label class="font-inner"> Password </label></div>
                            <div> <input type="password" name="password"></div>
                            <div> <button class="mybutton" style="width:100px;" type="submit" onclick="message()">LOGIN</button>  </div>           
                        </form>
                    </div>
                </div>
            </div>                                       
        </form>
    </body>
    <%String message = (String) request.getAttribute("alertMsg");%>
    <script type="text/javascript">
        function message(){
            var msg = "<%=message%>";
            if (isset(msg)) {
                alert(msg);
            }
        }
    </script>
</html>
