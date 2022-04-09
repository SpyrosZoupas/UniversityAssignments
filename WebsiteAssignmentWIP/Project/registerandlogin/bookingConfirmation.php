<!DOCTYPE html>
<html>
<head>
	<title>Booking Page</title>
</head>
<body>
	<form action="insertBooking.php" method="post">
	<h2>Are you sure you want to proceed with your booking?</h2>
	<?php
	session_start();
	echo "Day:" . $_SESSION['day'] . "Timeslot:" . $_SESSION['time'];
	?>
		<button type="submit">Confirm booking details</button>
	</form>
	<br>
</body>
</html>