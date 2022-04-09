<!DOCTYPE html>
<html>
<head>
	<title>Login to BiFlex</title>
</head>
<body>
    <h2>Welcome to BiFlex, please enter your details to log in</h2>
	<div class="container">
		<form action="insertLogin.php" method="post">
			<div class="form-input">
				<input type="text" name="username" placeholder="User Name"/>	
			</div>
			<div class="form-input">
				<input type="password" name="password" placeholder="Password"/>
			</div>
			<button type="submit">Login</button>
		</form>
	</div><br>
	<form action="register.php" method="post">
        <button type="submit">Don't have an account yet? Register here!</button>
    </form>
</body>
</html>