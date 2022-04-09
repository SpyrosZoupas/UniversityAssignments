<?php

//turn it into a function?

//Set up the database access credentials

$hostname = 'stu-db.aet.leedsbeckett.ac.uk';

$username = 'c3581829'; //your standard uni id

$password = 'MyDB23982146'; // the password found on the W: drive

$databaseName = 'c3581829'; //the name of the db you are using on phpMyAdmin

$connection = mysqli_connect($hostname, $username, $password, $databaseName) or exit("We're experiencing issues regarding our database, sorry for the inconvenience");

?>