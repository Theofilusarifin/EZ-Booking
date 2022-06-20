<?php
$sname = "localhost";
$suname = "root";
$password= "";

$db_name = "ezbooking";

$conn = mysqli_connect($sname, $suname, $password, $db_name);

if (!$conn){
    echo "Connection Failed!";
}
?>