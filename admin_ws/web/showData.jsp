<%-- 
    Document   : showData
    Created on : Jun 21, 2022, 12:16:36 AM
    Author     : MSI-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            @import url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700');

body {margin:0;}
                
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    position: fixed;
    top: 0;
    width: 100%;
    height:47px;
    box-shadow: 0 16px 31px -17px rgba(0, 50, 80, 0.5);
    background-color: #021A4A;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #F4CB0E;
    color:#021A4A;
}
                *, *:before, *:after {
                        box-sizing:border-box;
                }

                body {
                        font-family:'Poppins', sans-serif;
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
                        border:1px solid #F4CB0E;;
                }

                .table-header {
                        display:flex;
                        width:100%;
                        background:#F4CB0E;;
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
            
        </style>
    </head>
    <body>
    <ul>
    <li><a style="font-family: 'Vanessia Demo'; font-size:15px;">ezbooking</a></li>
    <li><a href="#showData" class="active">Restaurant Data</a></li>
    <li><a href="showBooking.jsp">Booking Data</a></li>
    <li style="float:right"><a class="active" href="index.jsp">Logout</a></li>
    </ul>
  
    <div class="container">
        <div class='table'>                  
            <div class='table-header'>
                <div class='header__item'id='name'>ID</div>
                <div class='header__item'id='name'>Name</div>
                <div class='header__item'id='name'>Address</div>
                <div class='header__item' id='name'>Phone Number</div>
                <div class='header__item'id='name'>Open Hour</div>
                <div class='header__item'id='name'>Close Hour</div>
                <div class='header__item' id='name'>Tables Count</div>
                <div class='header__item' id='name'>People per Table</div>
                <div class='header__item' id='name'>Owner</div>                
                <div class='header__item' id='name'>Show Bookings</div>

            </div>
            <div class='table-content'>
            <%
                try {
                    com.ezbooking.method.DisplayService_Service display = new com.ezbooking.method.DisplayService_Service();
                    com.ezbooking.method.DisplayService port = display.getDisplayServicePort();
                    java.lang.String data = port.display();

                    String[] collection = data.split("/&/");
                    for (String collect : collection) {
                        String[] attr = collect.split(";-;");
                        String id = attr[0];                    
                        String name = attr[1];
                        String address = attr[2];
                        String phone = attr[3];
                        String open = attr[4];
                        String close = attr[5];
                        String count = attr[6];
                        String table = attr[7];
                        String owner = attr[8];

                        out.println("<div class='table-row'>");
                        out.println("<div class='table-data'>"+id+"</div>");                    
                        out.println("<div class='table-data'>"+name+"</div>");
                        out.println("<div class='table-data'>"+address+"</div>");
                        out.println("<div class='table-data'>"+phone+"</div>");
                        out.println("<div class='table-data'>"+open+"</div>");
                        out.println("<div class='table-data'>"+close+"</div>");
                        out.println("<div class='table-data'>"+count+"</div>");
                        out.println("<div class='table-data'>"+table+"</div>");
                        out.println("<div class='table-data'>"+owner+"</div>"); 
                        out.println("<div class='table-data'>");  
                        out.println("<form method='POST' action='showBooking.jsp'>");
                        out.println("<input type='text' name='kode' value='"+id+"' hidden>");
                        out.println("<input type='submit' name='submit' value='Show'>");
                        out.println("</form>");
                        out.println("</div>");
                        out.println("</div>");

                    }
                }
                catch(Exception ex) {

                }
            %>
            </div>
        </div>

<!--            <div class="table">
                    <div class="table-header">
                            <div class="header__item"><a id="name" class="filter__link" href="#">Name</a></div>
                            <div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">Wins</a></div>
                            <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Draws</a></div>
                            <div class="header__item"><a id="losses" class="filter__link filter__link--number" href="#">Losses</a></div>
                            <div class="header__item"><a id="total" class="filter__link filter__link--number" href="#">Total</a></div>
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
            </div>-->
    </div>

        
        
    </body>
</html>
