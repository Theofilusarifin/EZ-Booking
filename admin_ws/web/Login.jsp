<%@page import="com.ezbooking.LoginService_Service"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Login
    Created on : Jun 19, 2022, 10:41:50 PM
    Author     : Meliyana
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
<!--        <link rel="stylesheet" href="style.css">-->

        <style type="text/css">    
                @import url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700');

                *, *:before, *:after {
                        box-sizing:border-box;
                }

                body {
                        font-family:'Source Sans Pro', sans-serif;
                        margin:0;
                }

                h1,h2,h3,h4,h5,h6 {
                        margin:0;
                }

                .container {
                        max-width: 1000px;  
                        margin-right:auto;
                        margin-left:auto;
                        display:flex;
                        justify-content:center;
                        align-items:center;
                        min-height:100vh;
                }

                .table {
                        width:100%;
                        border:1px solid black;
                }

                .table-header {
                        display:flex;
                        width:100%;
                        background:grey;
                }

                .table-row {
                        display:flex;
                        width:100%;
                }

                .table-data, .header__item {
                        flex: 1 1 20%;
                        text-align:center;
                }

                .header__item {
                        text-transform:uppercase;
                }
            

/*            .container{
                position:relative;
                left:38%;
                margin-top:8%;
            }
            body{
                background-color:#FFEB97;
            }
            .card{
                background-color:#021A4A;
                width:400px;
                height:400px;
                border-radius: 15px;
                text-align:center;
                position:absolute;
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
            }
            
            .group{
                margin-top:80px;
            }*/
        </style>
    </head>
    <body>
<<<<<<< Updated upstream
<!--        <div class="container">
            <div class="card">
                <div class="group">
                    <h1>LOGIN</h1>
                    <form>
                        <label class="font-inner"> Username </label><br>
                        <input type="text"><br><br>

                        <label class="font-inner"> Password </label><br>
                        <input type="text"><br><br>

                        <button class="mybutton" style="width:100px;">LOGIN</button>
                    </form>
                </div>
            </div>
                               
        </div>-->



<div class="container">

            <div class="table">
                    <div class="table-header">
                            <div class="header__item" ><a id="name">Name</a></div>
                            <div class="header__item"><a id="wins">Address</a></div>
                            <div class="header__item"><a id="draws">Phone Number</a></div>
                            <div class="header__item"><a id="losses">Open Hour</a></div>
                            <div class="header__item"><a id="total">Close Our</a></div>
                            <div class="header__item"><a id="total">Table Count</a></div>
                            <div class="header__item"><a id="total">People Per Table</div>
                    </div>
                    <div class="table-content">	
                            <div class="table-row">		
                                    <div class="table-data">Tom</div>
                                    <div class="table-data">2</div>
                                    <div class="table-data">0</div>
                                    <div class="table-data">1</div>
                                    <div class="table-data">5</div>
                            </div>
                            <div class="table-row">
                                    <div class="table-data">Dick</div>
                                    <div class="table-data">1</div>
                                    <div class="table-data">1</div>
                                    <div class="table-data">2</div>
                                    <div class="table-data">3</div>
                            </div>
                            <div class="table-row">
                                    <div class="table-data">Harry</div>
                                    <div class="table-data">0</div>
                                    <div class="table-data">2</div>
                                    <div class="table-data">2</div>
                                    <div class="table-data">2</div>
                            </div>
                    </div>	
            </div>
    </div>

=======
        <form action="<%=request.getContextPath()%>/loginprocess.jsp" method="post">  
            Username:<input type="text" name="username"><br>  
            Password:<input type="password" name="password"><br>
            <button type="submit">Submit</button>
        </form>
>>>>>>> Stashed changes
    </body>
</html>

