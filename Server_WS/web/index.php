<?php

include "db_conn.php";

if(isset($_POST['username']) && isset($_POST['password'])){
    $username = $_POST['username'];
    $password = $_POST['password'];

    if ($_POST['username'] == "" && $_POST['password'] == "") {
        header("Location: ../../admin_ws/web/admin.php?error=1");
        exit();
    } else if ($_POST['username'] == "") {
        header("Location: ../../admin_ws/web/admin.php?error=2");
        exit();
    } else if ($_POST['password'] == "") {
        header("Location: ../../admin_ws/web/admin.php?error=3");
        exit();
    } else {
        $sql = "select * from users where username = '$username' and password = '$password' and role = 'admin'";
        $result = mysqli_query($conn, $sql);
        if (mysqli_num_rows($result) === 1) {
            $row = mysqli_fetch_assoc($result);
            if ($row['username'] === $username && $row['password'] == $password) {
                // $_SESSION['username'] = $row['username'];
                // $_SESSION['name'] = $row['name'];
                // $_SESSION['id'] = $row['id'];
                header("Location: ../../admin_ws/web/dashboard.php");
                exit();
            } else {
                header("Location: ../../admin_ws/web/admin.php?error=4");
                exit();
            }
        } else {
            header("Location: ../../admin_ws/web/admin.php?error=4");
            exit();
        }
    }
} else {
    header("Location: ../../admin_ws/web/admin.php");
    exit();
}
