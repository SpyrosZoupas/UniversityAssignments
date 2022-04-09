<!DOCTYPE html>
<html>
<head>
	<title>Logout Page</title>
</head>
<body>
	<div class="container">
			<div class="form-input">
			<?php
			session_destroy()
			?>
			"You have Logged out. Would you like to log back in the website?"
			</div>
			<form action="login.php" method="post">
              <button type="submit">Log back in</button>
            </form>
	</div>
</body>
</html>