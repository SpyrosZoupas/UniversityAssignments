<html>
<head>
<title>Registration Page</title>
</head>
<body>
<form action="insertRecord.php" method="post">
<h2>Welcome to the registration page, please enter your details</h2>
Username: <input type="text" name="uname"><br>
Password: <input type="text" name="password"><br>
Repeat Password: <input type="text" name="password2"><br>
Email: <input type="text" name="email"><br>
Phone Number: <input type="text" name="phone"><br>
Date of Birth: <input type="text" name="dob"><br>
Gender: <input type="radio" name="gender"
<?php if (isset($gender) && $gender=="female") echo "checked";?>
value="female">Female
<input type="radio" name="gender"
<?php if (isset($gender) && $gender=="male") echo "checked";?>
value="male">Male
<input type="radio" name="gender"
<?php if (isset($gender) && $gender=="other") echo "checked";?>
value="other">Other<br>
<button type="submit">Register</button>
</form>
<br>
<form action="login.php" method="post">
<button type="submit">Already have an account? Login here!</button>
</form>
</body>
</html>