<?php
 //start session and include connection page
 session_start();
 include 'connection.php';

//generate unique booking id
$bid = uniqid();
$query = "INSERT INTO Bookings (CustomerID,BookingID,Age,Date,Time) VALUES ('".$_SESSION['id']."','$bid','".$_SESSION['age']."','".$_POST['date']."','".$_POST['time']."')";
echo $query;

//CustomerID column is unique, so if customer hasn't already booked a slot, booking goes through
if(mysqli_query($connection,$query)) {
    echo "Booking successful";
    if($_SESSION['age'] < 16) {
        echo "Warning: Since you are under 16 years of age, you'll have to come at the gym with a supervisor at all times.";
    } elseif($_SESSION['age'] < 18) {
        echo "Warning: Since you are under 18 years of age, you'll have to come with a supervisor after 20:00";
    }
} else {
    echo "You have already booked a slot at our gym, you are only allowed to book one slot. Would you like to cancel your booking?";
}

exit();
?>