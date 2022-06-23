<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

            <div class="table">
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
            </div>
    </div>

        
        
    </body>
</html>
