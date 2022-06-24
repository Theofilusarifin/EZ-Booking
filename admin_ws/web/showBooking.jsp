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
        <title>JSP Page</title>
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
                        background:#000;
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
        <div class="container">
        <div class='table'>                  
            <div class='table-header'>");
                <div class='header__item'><a id='name' class='filter__link' href='#'>Customer Name</a></div>
                <div class='header__item'><a id='name' class='filter__link' href='#'>Start Hour</a></div>
                <div class='header__item'><a id='name' class='filter__link' href='#'>End Hour</a></div>
                <div class='header__item'><a id='name' class='filter__link' href='#'>Tables Count</a></div>

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
                            out.println("<div class='table-data'>"+name+"</div>");                    
                            out.println("<div class='table-data'>"+start+"</div>");
                            out.println("<div class='table-data'>"+end+"</div>");
                            out.println("<div class='table-data'>"+table+"</div>");
                            out.println("</div>");

                        }
                    }
                    catch(Exception ex) {

                    }
                %>
            </div>
        </div>
        </div>
    </body>
</html>
