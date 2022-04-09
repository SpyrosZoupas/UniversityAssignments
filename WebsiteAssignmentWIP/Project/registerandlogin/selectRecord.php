<?php

//Make connection to database

include 'connection.php';

//Display heading

echo '<h2>Select ALL from the Customer Table</h2>';

//run query to select all records from customer table

$query="SELECT * FROM Customers";

//store the result of the query in a variable called $result

$result=mysqli_query($connection, $query);

//Use a while loop to iterate through your $result array and display

//the first name, last name and email for each record

while ($row=mysqli_fetch_assoc($result)){

echo $row['CustomerID'].' '.$row['Username'].' '.$row['Email'].' '.$row['DOB'].' '.$row['Gender'].'<br />';

}

?>