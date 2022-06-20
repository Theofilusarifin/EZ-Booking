<!DOCTYPE html>
<html>

<head>
    <title>Admin</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <div>
        <form action="../../Server_WS/web/index.php" method="POST">
            <label for="username">Username :</label>
            <input type="text" name="username" id="username"><br>
            <label for="password">Password :</label>
            <input type="password" name="password" id="password"><br>
            <button type="submit">LOGIN</button>
            <?php if (isset($_GET['error'])) {
                switch ($_GET['error']) {
                    case 1: ?>
                        <p class="error"> <?php echo "Username and Password is REQUIRED."; ?> </p>
                    <?php break;
                    case 2: ?>
                        <p class="error"> <?php echo "Username is REQUIRED."; ?> </p>
                    <?php break;
                    case 3: ?>
                        <p class="error"> <?php echo "Password is REQUIRED."; ?> </p>
                    <?php break;
                    case 4: ?>
                        <p class="error"> <?php echo "Incorrect Username or Password is inputted."; ?> </p>
                        <?php break; ?>
            <?php }
            } ?>
        </form>
    </div>
</body>

</html>