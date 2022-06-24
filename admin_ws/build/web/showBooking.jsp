<%-- 
    Document   : showBooking
    Created on : Jun 24, 2022, 1:12:33 PM
    Author     : REYNARD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Data</title>
        <style type="text/css">
            @import url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700');
            body {
                margin:0;
            }

            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                position: fixed;
                top: 0;
                width: 100%;
                height:52px;
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
                padding: 14px 50px;
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
                align-items:flex-start;
                min-height:100vh;
                margin-top:100px;
            }

            .table {
                width:100%;
                border:1px solid #F4CB0E;
            }

            .table-header {
                display:flex;
                width:100%;
                background:#F4CB0E;
            }

            .table-row {
                display:flex;
                width:100%;
            }

            .table-data, .header__item {
                flex: 1 1 100%;
                text-align:center;
                padding: 10px;
            }

            .header__item {
                text-transform:uppercase;
            }

        </style>
    </head>
    <body>
        <ul>
            <li><a style="font-family: 'Vanessia Demo'; font-size:15px;">ezbooking</a></li>
            <li><a href="showData.jsp" >Restaurant Data</a></li>
            <li style="float:right"><a href="index.jsp">Logout</a></li>
        </ul>
        <div class="container">
            <div class='table'>                  
                <div class='table-header'>
                    <div class='header__item'id='name'> Customer Name</div>
                    <div class='header__item'id='name'> Start Hour</div>
                    <div class='header__item'id='name'> End Hour</div>
                    <div class='header__item'id='name'> Tables Count</div>

                </div>
                <div class='table-content'>
                    <%
                        try {
                            com.ezbooking.method.DisplayService_Service display = new com.ezbooking.method.DisplayService_Service();
                            com.ezbooking.method.DisplayService port = display.getDisplayServicePort();
                            java.lang.String kode = request.getParameter("kode");
                            java.lang.String data = port.displayBook(kode);

                            String[] collection = data.split("/&/");
                            for (String collect : collection) {
                                String[] attr = collect.split(";-;");
                                String name = attr[0];
                                String start = attr[1];
                                String end = attr[2];
                                String table = attr[3];

                                out.println("<div class='table-row'>");
                                out.println("<div class='table-data'>" + name + "</div>");
                                out.println("<div class='table-data'>" + start + "</div>");
                                out.println("<div class='table-data'>" + end + "</div>");
                                out.println("<div class='table-data'>" + table + "</div>");
                                out.println("</div>");

                            }
                        } catch (Exception ex) {

                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
