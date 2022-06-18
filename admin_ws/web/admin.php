<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <title>Admin</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <div>
        <form action=<?php echo $_SERVER['DOCUMENT_ROOT'] . '/DistributedProgramming/Project UAS/project_disprog/Server_WS/web/'; ?> method="POST">
            <label for="username">Username :</label>
            <input type="text" name="username" id="username"><br>
            <label for="password">Password :</label>
            <input type="text" name="password" id="password"><br>
            <button type="submit">LOGIN</button>
        </form>
        <a href=>To Server_WS</a>
    </div>
</body>

</html>