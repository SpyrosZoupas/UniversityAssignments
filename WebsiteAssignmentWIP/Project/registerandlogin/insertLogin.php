<?php

session_start();
$sid = session_id();

//Make connection to database
include 'connection.php';

//if there is input for the username, gather submitted data from $_POST
if(isset($_POST['username'])) {
    $_SESSION['uname'] = $_POST['username'];
    $password = $_POST['password'];
    
    //select hashed password from database and store the query result in a variable
    $query2 = "SELECT Password FROM Customers WHERE Username = '".$_SESSION['uname']."'";
    $result2 = mysqli_query($connection, $query2);
    //check whether username has a matching password, if not username does not exist
    if (mysqli_num_rows($result2) > 0) {
        while($row = mysqli_fetch_assoc($result2)) {
                //compare hashed and unhashed passwords
                if(password_verify($password,$row["Password"])) {
        
    
    //Construct SELECT query using variables holding data gathered
    $query = "SELECT Username,Password FROM Customers WHERE Username = '".$_SESSION['uname']."' AND Password = '".$row["Password"]."' LIMIT 1";
    
    //echo query for debug
    echo $query;
    
    //store the result of the query in a variable called $result
    $result = mysqli_query($connection, $query);
    
    //if username and password are on the same row (same user) log in works
    //else display appropriate error message
    if(mysqli_num_rows($result) == 1) {
         mysqli_free_result($result);
         $query = "SELECT CustomerID,Age FROM Customers WHERE Username = '".$_SESSION['uname']."'";
         echo $query;
         $result = mysqli_query($connection, $query);
         $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
         $_SESSION['id'] = $row["CustomerID"];
         $_SESSION['age'] = $row["Age"];
         header("Location: homepage.php");
    } else {
        $query = "SELECT * FROM Customers WHERE Username = '".$_SESSION['uname']."'";
        $result = mysqli_query($connection,$query);
        if($result) {
            if(mysqli_num_rows($result) > 0) {
                echo 'The password you entered was incorrect, please try again.';
            } else {
                echo 'The username or password you entered was incorrect, please try again.';
            }
        }
    }
} else {
    //if hashed and unhashed passwords don't match then the password is wrong
    echo "Wrong Password, please try again.";
}
        }
        } else {
            echo "Wrong Username, please try again.";
            }

}
exit();
?>