<?php

//Make connection to database

include 'connection.php';

//Gather from $_POST[]all the data submitted and store in variables
$uname=$_POST['uname'];
$password=$_POST['password'];
$password2=$_POST['password2'];
$email=$_POST['email'];
$phone=$_POST['phone'];
$dob=$_POST['dob'];
$gender=$_POST['gender'];

//make $phone a string to calculate phone length
$phone_length = strlen((string)$phone);
$phone = intval($phone);
  
//check whether passwords match
if($password != $password2) {
    echo "Passwords don't match, please try again.";
} elseif(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    echo "Please insert a valid email address.";
} else {
  //generate hashed password
  $hashed_password = password_hash($password, PASSWORD_DEFAULT);

  
  //explode date to get month,day,year
  $birthDate = explode("-", $dob);

  //calculate age using date of birth
  $age = (date("md", date("U", mktime(0, 0, 0, $birthDate[2], $birthDate[1], $birthDate[0]))) > date("md") ? ((date("Y")-$birthDate[0])):(date("Y")-$birthDate[0]));
  
  //generate customer id
  $id = uniqid();
  
  //Construct INSERT query using variables holding data gathered
  $query="INSERT INTO Customers (CustomerID,Username,Password,Email,Phone,DOB,Gender,Age) VALUES ('$id','$uname', '$hashed_password','$email','$phone','$dob','$gender','$age')";
  //Temporarily echo $query for debugging purposes
  echo $query;

  //run $query
  if(mysqli_query($connection, $query)) {
      echo "Registration successful.";
      header("Location: login.php");
  } else {
        $query = "SELECT * FROM Customers WHERE Username = '".$uname."'";
        $result = mysqli_query($connection,$query);
        if($result) {
            if(mysqli_num_rows($result) > 0) {
                echo 'Username already in use!';
            } elseif($phone_length > 10 || !is_int($phone)) {
                echo "Please insert a valid phone number";
            } else {
                    echo "ERROR: Something went wrong, please try registering again." . mysqli_error($connection);
                }
            } 
        } 
  }

exit();


?>