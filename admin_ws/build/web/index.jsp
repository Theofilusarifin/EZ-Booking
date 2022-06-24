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
        <title>ezbooking | Login</title>
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
                height:340px;
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
            .mybutton{
                font-family: 'Poppins', sans-serif;
                font-weight: normal;
                margin: 12px;
                width: 100px; 
                background-color:#F4CB0E; 
                border:0; 
                border-radius: 10px;
                color:#021A4A;
                font-weight: bold;
                padding: 10px;
            }
            p,h1,h2,h3,h4,h5,h6,label{
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
    <body>
        <form action="<%=request.getContextPath()%>/loginprocess.jsp" method="post">  
            <div class="logo"> ezbooking </div>
            <div class="container">
                <div class="card">
                    <div class="group">
                        <h1>LOGIN</h1>
                        <form>
                            <div> <label class="font-inner"> Username </label></div>
                            <div> <input type="text" name="username" style="padding: 10px;"></div>
                            <div> <label class="font-inner"> Password </label></div>
                            <div> <input type="password" name="password" style="padding: 10px;"></div>
                            <div> <button class="mybutton" type="submit" onclick="message()">LOGIN</button>  </div>           
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
